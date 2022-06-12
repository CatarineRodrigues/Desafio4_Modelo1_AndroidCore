package br.com.zup.simcitysaojoao.produtos.fragments.detalhes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import br.com.zup.simcitysaojoao.*
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
        val produto = arguments?.getParcelable<Produto>(PRODUTO_KEY)
        if (produto != null) {
            exibirDetalhes(produto = produto)
        }
    }

    private fun exibirDetalhes(produto: Produto) {
        binding.tvNomeProduto.text = produto.getNome()
        binding.tvQuantidade.text = QUANTIDADE + produto.getQuantidade().toString()
        binding.tvValorUnitario.text = VALOR_UNIT + produto.getValorUnit().toString()
        binding.tvReceita.text = RECEITA + produto.getReceita()
    }

    private fun favoritarProduto() {
        binding.icFavoritar.setOnClickListener {
            Toast.makeText(context, MSG_FAVORITADO, Toast.LENGTH_LONG).show()
        }
    }
}