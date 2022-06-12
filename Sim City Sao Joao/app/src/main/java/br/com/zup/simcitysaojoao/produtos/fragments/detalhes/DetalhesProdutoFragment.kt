package br.com.zup.simcitysaojoao.produtos.fragments.detalhes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import br.com.zup.simcitysaojoao.R
import br.com.zup.simcitysaojoao.databinding.FragmentDetalhesProdutoBinding
import br.com.zup.simcitysaojoao.model.Produto

class DetalhesProdutoFragment : Fragment() {
    private lateinit var binding: FragmentDetalhesProdutoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetalhesProdutoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recuperarProduto()
        favoritarProduto()
    }

    private fun recuperarProduto() {
        val produto = arguments?.getParcelable<Produto>("produto")
        if (produto != null) {
            exibirDetalhes(produto = produto)
        }
    }

    private fun exibirDetalhes(produto: Produto){
        binding.tvNomeProduto.text = produto.getNome()
        binding.tvQuantidade.text = "${R.id.tvQuantidade} ${produto.getQuantidade()}"
        binding.tvValorUnitario.text = "${R.string.text_valor_unitario} ${produto.getValorUnit()}"
        binding.tvReceita.text = "${R.string.text_receita}: ${produto.getReceita()}"
    }

    private fun favoritarProduto(){
        binding.icFavoritar.setOnClickListener {
            Toast.makeText(context, "Produto Favoritado!", Toast.LENGTH_LONG).show()
        }
    }
}