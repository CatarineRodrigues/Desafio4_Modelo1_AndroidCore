package br.com.zup.simcitysaojoao.produtos

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import br.com.zup.simcitysaojoao.R
import br.com.zup.simcitysaojoao.databinding.ActivityProdutosBinding

class ProdutosActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProdutosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProdutosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        acessarActionBar()
    }

    private fun acessarActionBar() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.produtos)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}