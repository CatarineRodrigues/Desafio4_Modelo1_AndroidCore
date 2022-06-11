package br.com.zup.simcitysaojoao.produtos.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import br.com.zup.simcitysaojoao.R
import br.com.zup.simcitysaojoao.databinding.FragmentCadastrarProdutosBinding

class CadastrarProdutosFragment : Fragment() {
    private lateinit var binding: FragmentCadastrarProdutosBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCadastrarProdutosBinding.inflate(inflater, container, false)
        return binding.root
    }


}