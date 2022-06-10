package br.com.zup.simcitysaojoao.produtos.fragments.detalhes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.zup.simcitysaojoao.R
import br.com.zup.simcitysaojoao.databinding.FragmentDetalhesProdutoBinding

class DetalhesProdutoFragment : Fragment() {
    private lateinit var binding: FragmentDetalhesProdutoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetalhesProdutoBinding.inflate(inflater, container, false)
        return binding.root
    }
}