package src.main.java.com.example.meu_projeto_pi

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.meu_projeto_pi.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EditarDespesaActivity {




        private lateinit var nomeEditText: EditText
        private lateinit var valorEditText: EditText
        private lateinit var vencimentoEditText: EditText
        private lateinit var categoriaEditText: EditText
        private lateinit var tipoEditText: EditText
        private lateinit var recebedorEditText: EditText
        private lateinit var statusEditText: EditText
        private lateinit var salvarButton: Button

        private var despesaId: Int = 0

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_editar_produto)

            nomeEditText = findViewById(R.id.nomeEditText)
            valorEditText = findViewById(R.id.valorEditText)
            vencimentoEditText = findViewById(R.id.vencimentoEditText)
            categoriaEditText = findViewById(R.id.categoriaEditText)
            tipoEditText = findViewById(R.id.tipoEditText)
            recebedorEditText = findViewById(R.id.recebedorEditText)
            statusEditText = findViewById(R.id.statusEditText)
            salvarButton = findViewById(R.id.salvarButton)

            // Resgatar os dados passados pela Intent
            despesaId = intent.getIntExtra("DESPESA_ID", 0)
            nomeEditText.setText(intent.getStringExtra("DESPESA_NOME"))
            valorEditText.setText(intent.getStringExtra("DESPESA_VALOR"))
            vencimentoEditText.setText(intent.getStringExtra("DESPESA_VENCIMENTO"))
            categoriaEditText.setText(intent.getStringExtra("DESPESA_CATEGORIA"))
            tipoEditText.setText(intent.getStringExtra("DESPESA_TIPO"))
            recebedorEditText.setText(intent.getStringExtra("DESPESA_RECEBEDOR"))
            statusEditText.setText(intent.getStringExtra("DESPESA_STATUS"))


            val retrofit = Retrofit.Builder()
                .baseUrl("http://192.168.56.1/meu_projeto_api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val apiService3 = retrofit.create(ApiService3::class.java)

            salvarButton.setOnClickListener {

                val despesaAtualizada = Despesa(
                    despesaId,
                    nomeEditText.text.toString(),
                    valorEditText.text.toString(),
                    vencimentoEditText.text.toString(),
                    categoriaEditText.text.toString(),
                    tipoEditText.text.toString(),
                    recebedorEditText.text.toString(),
                    statusEditText.text.toString(),

                )

                apiService.editarDespesa(
                    despesaAtualizada.DESPESA_ID,
                    despesaAtualizada.DESPESA_NOME,
                    despesaAtualizada.DESPESA_VALOR,
                    despesaAtualizada.DESPESA_VENCIMENTO,
                    despesaAtualizada.DESPESA_CATEGORIA,
                    despesaAtualizada.DESPESA_TIPO,
                    despesaAtualizada.DESPESA_RECEBEDOR,
                    despesaAtualizada.DESPESA_STATUS
                ).enqueue(object : Callback<Void> {
                    override fun onResponse(call: Call<Void>, response: Response<Void>) {
                        if (response.isSuccessful) {
                            Toast.makeText(this@EditarDespesaActivity, "Despesa atualizada com sucesso!", Toast.LENGTH_LONG).show()
                            finish()
                        } else {
                            Toast.makeText(this@EditarDespesaActivity, "Erro na atualização", Toast.LENGTH_LONG).show()
                        }
                    }

                    override fun onFailure(call: Call<Void>, t: Throwable) {
                        Toast.makeText(this@EditarDespesaActivity, "Erro ao atualizar a despesa", Toast.LENGTH_LONG).show()
                    }
                })
            }
        }
    }

