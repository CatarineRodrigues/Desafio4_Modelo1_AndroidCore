package br.com.zup.simcitysaojoao.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.zup.simcitysaojoao.databinding.ActivityMainBinding
import br.com.zup.simcitysaojoao.produtos.ProdutosActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        clicarBotaoIrProdutos(irParaCadastrarProdutos())
    }

    private fun clicarBotaoIrProdutos(intent: Intent) {
        binding.btnIrProdutos.setOnClickListener {
            startActivity(intent)
        }
    }

    private fun irParaCadastrarProdutos() = Intent(this, ProdutosActivity::class.java)
}
