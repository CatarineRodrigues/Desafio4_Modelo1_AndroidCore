package br.com.zup.simcitysaojoao.produtos.fragments

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import br.com.zup.simcitysaojoao.R
import br.com.zup.simcitysaojoao.databinding.FragmentCadastrarProdutosBinding
import br.com.zup.simcitysaojoao.model.Produto
import br.com.zup.simcitysaojoao.produtos.ProdutosActivity
import br.com.zup.simcitysaojoao.produtos.fragments.adapter.ProdutoAdapter

class CadastrarProdutosFragment : Fragment() {

    private lateinit var binding: FragmentCadastrarProdutosBinding
    private lateinit var nome: String
    private lateinit var qnt: String
    private lateinit var valorUn: String
    private lateinit var receita: String
    private val listaNovaProduto = mutableListOf<Produto>()

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
            Toast.makeText(context, "Preencha os campos primeiro", Toast.LENGTH_LONG).show()
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
        val bundle = bundleOf("lista" to listaNovaProduto)

        NavHostFragment.findNavController(this).navigate(
            R.id.action_cadastrarProdutosFragment_to_listaCadastradosFragment, bundle
        )
    }

    private fun clicarBotaoValorTotal() {
        binding.btnValorTotal.setOnClickListener {
            irParaValorTotal()
        }
    }

    private fun irParaValorTotal() {
        val bundle = bundleOf("valores" to listaNovaProduto)

        NavHostFragment.findNavController(this).navigate(
            R.id.action_cadastrarProdutosFragment_to_valorTotalFragment
        )
    }


}