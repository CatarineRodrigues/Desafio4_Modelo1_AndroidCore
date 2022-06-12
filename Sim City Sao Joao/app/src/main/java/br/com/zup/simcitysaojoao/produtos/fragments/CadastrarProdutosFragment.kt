package br.com.zup.simcitysaojoao.produtos.fragments

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import br.com.zup.simcitysaojoao.LISTA_KEY
import br.com.zup.simcitysaojoao.MSG_PREENCHA_CAMPOS
import br.com.zup.simcitysaojoao.R
import br.com.zup.simcitysaojoao.databinding.FragmentCadastrarProdutosBinding
import br.com.zup.simcitysaojoao.model.Produto
import br.com.zup.simcitysaojoao.produtos.ProdutosActivity

class CadastrarProdutosFragment : Fragment() {

    private lateinit var binding: FragmentCadastrarProdutosBinding
    private lateinit var nome: String
    private lateinit var qnt: String
    private lateinit var valorUn: String
    private lateinit var receita: String
    private var listaNovaProduto = mutableListOf<Produto>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCadastrarProdutosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clicarBotaoCadastrarNovoProduto()
        clicarBotaoVerProdutos()
        clicarBotaoValorTotal()
        recuperarlistaProdutos()
    }

    private fun adicionarItemListaProdutos() {
        recuperarDados()
        if (!verificarCampos()) {
            val produto = Produto(
                nome = nome,
                quantidade = qnt.toInt(),
                valorUnitario = valorUn.toDouble(),
                receita = receita
            )
            listaNovaProduto.add(produto)
        }
    }

    private fun clicarBotaoCadastrarNovoProduto() {
        binding.btnCadastrarNovoProduto.setOnClickListener {
            adicionarItemListaProdutos()
            limparCampos()
        }
    }

    private fun recuperarDados() {
        this.nome = binding.etNomeProduto.text.toString()
        this.qnt = binding.etQntProduto.text.toString()
        this.valorUn = binding.etValorProduto.text.toString()
        this.receita = binding.etReceita.text.toString()
    }

    private fun limparCampos() {
        binding.etNomeProduto.text.clear()
        binding.etQntProduto.text.clear()
        binding.etValorProduto.text.clear()
        binding.etReceita.text.clear()
    }

    fun verificarCampos(): Boolean {
        val context = context as ProdutosActivity
        return if (nome.isEmpty() || qnt.isEmpty() || valorUn.isEmpty() || receita.isEmpty()) {
            Toast.makeText(context, MSG_PREENCHA_CAMPOS, Toast.LENGTH_LONG).show()
            true
        } else {
            false
        }
    }

    private fun clicarBotaoVerProdutos() {
        binding.btnVerProdutos.setOnClickListener {
            irParaListaCadastrados()
        }
    }

    private fun irParaListaCadastrados() {
        NavHostFragment.findNavController(this).navigate(
            R.id.action_cadastrarProdutosFragment_to_listaCadastradosFragment, bundleListaNova()
        )
    }

    private fun clicarBotaoValorTotal() {
        binding.btnValorTotal.setOnClickListener {
            irParaValorTotal()
        }
    }

    private fun irParaValorTotal() {
        NavHostFragment.findNavController(this).navigate(
            R.id.action_cadastrarProdutosFragment_to_valorTotalFragment, bundleListaNova()
        )
    }

    private fun bundleListaNova(): Bundle {
        return bundleOf(LISTA_KEY to listaNovaProduto)
    }

    private fun recuperarlistaProdutos() {
        val lista = arguments?.getParcelableArrayList<Produto>(LISTA_KEY)
        if (lista != null) {
            atualizarListaProdutos(lista)
        }
    }

    fun atualizarListaProdutos(novaLista: ArrayList<Produto>) {
        if (listaNovaProduto.size == 0) {
            listaNovaProduto = novaLista
        } else if (listaNovaProduto.containsAll(novaLista)){
        } else {
            listaNovaProduto.addAll(novaLista)
        }
    }
}