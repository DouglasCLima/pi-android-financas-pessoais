package src.main.java.com.example.meu_projeto_pi.api
import android.telecom.Call
import com.example.meu_projeto_pi.Despesa_Receita
import retrofit2.Call
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST
import java.util.Date


class ApiService3 {

    @GET("despesas.php")
    fun getDespesas(): Call<List<Despesa_Receita>>

    @FormUrlEncoded
    @POST("incluir_despesa.php")
    fun incluirDespesa(
        @Field("DESPESA_NOME") despesaNome: String,
        @Field("DESPESA_VALOR") despesaValor: Double,
        @Field("DESPESA_VENCIMENTO") despesaVencimento: Date,
        @Field("DESPESA_CATEGORIA") despesaCategoria: String,
        @Field("DESPESA_TIPO") despesaTipo: String,
        @Field("DESPESA_RECEBEDOR") despesaRecebedor: String,
        @Field("DESPESA_STATUS") despesaStatus: String,
    ): Call<Void>

    @FormUrlEncoded
    @POST("editar_produto.php")
    fun editarDespesa(
        @Field("DESPESA_NOME") despesaNome: String,
        @Field("DESPESA_VALOR") despesaValor: Double,
        @Field("DESPESA_VENCIMENTO") despesaVencimento: Date,
        @Field("DESPESA_CATEGORIA") despesaCategoria: String,
        @Field("DESPESA_TIPO") despesaTipo: String,
        @Field("DESPESA_RECEBEDOR") despesaRecebedor: String,
        @Field("DESPESA_STATUS") despesaStatus: String,
    ): Call<Void>


    @FormUrlEncoded
    @POST("deletar_despesa.php")
    fun deletarDespesa(
        @Field("DESPESA_ID") id: Int
    ): Call<Void>

}




}