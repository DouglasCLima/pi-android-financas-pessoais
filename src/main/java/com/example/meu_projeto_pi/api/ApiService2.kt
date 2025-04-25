package com.example.meu_projeto_pi.api
import com.example.meu_projeto_pi.Despesa_Receita
import retrofit2.Call
import retrofit2.http.GET

interface ApiService2 {
    @GET("despesas.php")
    fun getDespesas(): Call<List<Despesa_Receita>>
}
