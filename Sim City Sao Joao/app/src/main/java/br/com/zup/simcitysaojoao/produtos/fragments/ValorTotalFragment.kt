package br.com.zup.simcitysaojoao.produtos.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.NavHostFragment
import br.com.zup.simcitysaojoao.LISTA_KEY
import br.com.zup.simcitysaojoao.MSG_VALOR_TOTAL
import br.com.zup.simcitysaojoao.R
import br.com.zup.simcitysaojoao.databinding.FragmentValorTotalBinding
import br.com.zup.simcitysaojoao.model.Produto
import br.com.zup.simcitysaojoao.produtos.ProdutosActivity
import br.com.zup.simcitysaojoao.produtos.fragments.adapter.ProdutoAdapter

class ValorTotalFragment : Fragment() {
    private lateinit var binding: FragmentValorTotalBinding
    private lateinit var listaRecebida: ArrayList<Produto>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentValorTotalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as ProdutosActivity).supportActionBar?.title = getString(R.string.text_valor_total)
        recuperarlistaProdutos()
        clicarBotaoCadastrarNovoProduto()
        clicarBotaoVerProdutos()
    }

    private fun recuperarlistaProdutos() {
        val lista = arguments?.getParcelableArrayList<Produto>(LISTA_KEY)
        if (lista != null) {
            listaRecebida = lista
            calcularValorTotal(listaRecebida)
        }
    }

    private fun bundleListaRecebida(): Bundle {
        return bundleOf(LISTA_KEY to listaRecebida)
    }

    private fun calcularValorTotal(listaProdutos: ArrayList<Produto>) {
        var somatoria = 0.0
        listaProdutos.forEach {
            somatoria += it.getValorTotal()
        }
        exibirValorTotal(somatoria)
    }

    private fun exibirValorTotal(valorTotal: Double) {
        binding.tvValorTotal.text = MSG_VALOR_TOTAL + valorTotal
    }

    private fun clicarBotaoCadastrarNovoProduto() {
        binding.btnCadastrarNovoProduto.setOnClickListener {
            irParaCadastrarProdutos()
        }
    }

    private fun irParaCadastrarProdutos() {
        NavHostFragment.findNavController(this).navigate(
            R.id.action_valorTotalFragment_to_cadastrarProdutosFragment, bundleListaRecebida()
        )
    }

    private fun clicarBotaoVerProdutos() {
        binding.btnVerProdutos.setOnClickListener {
            irParaListaCadastrados()
        }
    }

    private fun irParaListaCadastrados() {
        NavHostFragment.findNavController(this).navigate(
            R.id.action_valorTotalFragment_to_listaCadastradosFragment, bundleListaRecebida()
        )
    }
}