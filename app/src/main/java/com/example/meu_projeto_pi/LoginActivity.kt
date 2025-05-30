package com.example.meu_projeto_pi
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.meu_projeto_pi.api.ApiService
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory


data class LoginResponse(
    val id: Int,
    val name: String?,
    val email: String?
)


class LoginActivity : AppCompatActivity() {


    private lateinit var emailEditText: EditText
    private lateinit var senhaEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        emailEditText = findViewById(R.id.emailEditText)
        senhaEditText = findViewById(R.id.senhaEditText)
        val btnLogin: Button = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener { blockLogin() }

    }

    private fun blockLogin() {
        val email = emailEditText.text.toString().trim()
        val senha = senhaEditText.text.toString().trim()

        if (email.isEmpty() || senha.isEmpty()) {
            Toast.makeText(this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show()
            return
        }

        val retrofit = Retrofit.Builder()
            //.baseUrl("http://10.135.111.20/")
            .baseUrl("http://10.135.111.36/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(ApiService::class.java)

        val call = apiService.login(email, senha)
        call.enqueue(object : Callback<List<LoginResponse>> {
            override fun onResponse(
                call: Call<List<LoginResponse>>,
                response: Response<List<LoginResponse>>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    val loginResponse = response.body()!!
                    if (loginResponse.isNotEmpty()) {
                        val intent = Intent(this@LoginActivity, DespesasActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(
                            this@LoginActivity,
                            "Usuário ou senha inválidos",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                } else {
                    Toast.makeText(
                        this@LoginActivity,
                        "Erro no login",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

            override fun onFailure(call: Call<List<LoginResponse>>, t: Throwable) {
                Toast.makeText(this@LoginActivity,
                    "Erro: ${t.message}",
                    Toast.LENGTH_LONG
                ).show()
            }
        })
    }
}