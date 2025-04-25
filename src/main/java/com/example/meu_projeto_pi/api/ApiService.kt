package com.example.meu_projeto_pi.api

import com.example.meu_projeto_pi.LoginResponse
import retrofit2.*

interface ApiService {

    @GET("/api/login.php")
    fun login(
        @Query("usuario") usuario: String,
        @Query("senha") senha: String
    ): Call<List<LoginResponse>>
}
