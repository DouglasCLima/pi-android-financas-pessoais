package com.example.meu_projeto_pi
import java.time.LocalDate
import java.util.Date

data class Despesa_Receita (
    val DESPESA_ID: Int,
    val DESPESA_NOME: String,
    val DESPESA_VALOR: Double,
    val DESPESA_VENCIMENTO: Date,
    val DESPESA_CATEGORIA: String,
    val DESPESA_TIPO: String,
    val DESPESA_RECEBEDOR: String,
    val DESPESA_STATUS: String
)
