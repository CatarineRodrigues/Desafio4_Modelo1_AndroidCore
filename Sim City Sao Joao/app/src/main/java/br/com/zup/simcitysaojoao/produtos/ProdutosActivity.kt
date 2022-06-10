package br.com.zup.simcitysaojoao.produtos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.zup.simcitysaojoao.databinding.ActivityProdutosBinding

class ProdutosActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProdutosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProdutosBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}