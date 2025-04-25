package com.example.meu_projeto_pi

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.Toast
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val dataSet: List<Despesa_Receita>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nome: TextView = view.findViewById(R.id.nomeDespesa)
        val valor: TextView = view.findViewById(R.id.valorDespesa)
        val vencimento: TextView = view.findViewById(R.id.vencimentoDespesa)
        val categoria: TextView = view.findViewById(R.id.categoriaDespesa)
        val tipo: TextView = view.findViewById(R.id.tipoDespesa)
        val recebedor: TextView = view.findViewById(R.id.recebedorDespesa)
        val status: TextView = view.findViewById(R.id.statusDespesa)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.detalhe_despesas, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val despesa = dataSet[position]
        viewHolder.nome.text = despesa.DESPESA_NOME
        viewHolder.valor.text = despesa.DESPESA_VALOR.toString()
        viewHolder.vencimento.text = despesa.DESPESA_VENCIMENTO.toString()
        viewHolder.categoria.text = despesa.DESPESA_CATEGORIA
        viewHolder.tipo.text = despesa.DESPESA_TIPO.toString()
        viewHolder.recebedor.text = despesa.DESPESA_RECEBEDOR
        viewHolder.status.text = despesa.DESPESA_STATUS
    }

    viewHolder.editarButton.setOnClickListener {
        val intent = Intent(it.context, EditarDespesaActivity::class.java)
        intent.putExtra("DESPESA_ID", despesa.DESPESA_ID)
        intent.putExtra("DESPESA_NOME", despesa.DESPESA_NOME)
        intent.putExtra("DESPESA_VALOR", despesa.DESPESA_VALOR)
        intent.putExtra("DESPESA_VENCIMENTO", despesa.DESPESA_VENCIMENTO)
        intent.putExtra("DESPESA_CATEGORIA", despesa.DESPESA_CATEGORIA)
        intent.putExtra("DESPESA_TIPO", despesa.DESPESA_TIPO)
        intent.putExtra("DESPESA_RECEBEDOR", despesa.DESPESA_RECEBEDOR)
        intent.putExtra("DESPESA_STATUS", despesa.DESPESA_STATUS)
        it.context.startActivity(intent)
    }

    viewHolder.deletarButton.setOnClickListener {
        apiService.deletarProduto(despesa.DESPESA_ID).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                Toast.makeText(it.context, "Produto deletado com sucesso!", Toast.LENGTH_LONG).show()
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(it.context, "Erro ao deletar o produto", Toast.LENGTH_LONG).show()
            }
        })
    }
}


override fun getItemCount() = dataSet.size
}






