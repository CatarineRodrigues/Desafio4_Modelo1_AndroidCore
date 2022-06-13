package br.com.zup.simcitysaojoao.produtos.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import br.com.zup.simcitysaojoao.LISTA_KEY
import br.com.zup.simcitysaojoao.PRODUTO_KEY
import br.com.zup.simcitysaojoao.R
import br.com.zup.simcitysaojoao.databinding.FragmentListaCadastradosBinding
import br.com.zup.simcitysaojoao.model.Produto
import br.com.zup.simcitysaojoao.produtos.ProdutosActivity
import br.com.zup.simcitysaojoao.produtos.fragments.adapter.ProdutoAdapter

class ListaCadastradosFragment : Fragment() {
    private lateinit var binding: FragmentListaCadastradosBinding
    private val produtoAdapter: ProdutoAdapter by lazy {
        ProdutoAdapter(arrayListOf(), ::irParaDetalhesProduto)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListaCadastradosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as ProdutosActivity).supportActionBar?.title = getString(R.string.produtos)
        recuperarLista()
    }

    private fun irParaDetalhesProduto(produto: Produto) {
        val bundle = bundleOf(PRODUTO_KEY to produto)

        NavHostFragment.findNavController(this).navigate(
            R.id.action_listaCadastradosFragment_to_detalhesProdutoFragment, bundle
        )
    }

    private fun recuperarLista() {
        val lista = arguments?.getParcelableArrayList<Produto>(LISTA_KEY)
        if (lista != null) {
            atualizarLista(lista)
        }
    }

    private fun atualizarLista(lista: ArrayList<Produto>) {
        produtoAdapter.atualizarListaProdutos(lista)
        exibirRecyclerView()
    }

    private fun exibirRecyclerView() {
        binding.rvListaProdutosCadastrados.adapter = produtoAdapter
        binding.rvListaProdutosCadastrados.layoutManager = LinearLayoutManager(context)
    }
}