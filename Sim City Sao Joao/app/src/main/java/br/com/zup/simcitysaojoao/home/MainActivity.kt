package br.com.zup.simcitysaojoao.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import br.com.zup.simcitysaojoao.databinding.ActivityMainBinding
import br.com.zup.simcitysaojoao.produtos.ProdutosActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        irParaCadastrarProdutos()
    }

    private fun irParaCadastrarProdutos(){
        binding.btnIrProdutos.setOnClickListener {
            val intent = Intent(this, ProdutosActivity::class.java)
            startActivity(intent)
        }
    }
}