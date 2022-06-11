package br.com.zup.simcitysaojoao.produtos.fragments.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.simcitysaojoao.databinding.ProdutoItemBinding
import br.com.zup.simcitysaojoao.model.Produto

class ProdutoAdapter(
    private var listaProduto: MutableList<Produto>
) : RecyclerView.Adapter<ProdutoAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoAdapter.ViewHolder {
        val binding = ProdutoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProdutoAdapter.ViewHolder, position: Int) {
        val produto = listaProduto[position]
        holder.exibirInformacoesView(produto)
    }

    override fun getItemCount(): Int {
        return listaProduto.size
    }

    class ViewHolder(val binding: ProdutoItemBinding): RecyclerView.ViewHolder(binding.root){
        fun exibirInformacoesView(produto: Produto){
            binding.tvQntENomeProduto.text = "${produto.getQuantidade()} - ${produto.getNome()}"
        }
    }
}