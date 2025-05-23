package com.example.meu_projeto_pi


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

    override fun getItemCount() = dataSet.size
}