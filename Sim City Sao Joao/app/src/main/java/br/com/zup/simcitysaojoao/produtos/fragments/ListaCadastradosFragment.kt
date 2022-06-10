package br.com.zup.simcitysaojoao.produtos.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.zup.simcitysaojoao.R
import br.com.zup.simcitysaojoao.databinding.FragmentListaCadastradosBinding

class ListaCadastradosFragment : Fragment() {
    private lateinit var binding: FragmentListaCadastradosBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListaCadastradosBinding.inflate(inflater, container, false)
        return binding.root
    }
}