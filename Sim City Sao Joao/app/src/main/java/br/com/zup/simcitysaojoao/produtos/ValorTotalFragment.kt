package br.com.zup.simcitysaojoao.produtos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.zup.simcitysaojoao.R
import br.com.zup.simcitysaojoao.databinding.FragmentValorTotalBinding

class ValorTotalFragment : Fragment() {
    private lateinit var binding: FragmentValorTotalBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentValorTotalBinding.inflate(inflater, container, false)
        return binding.root
    }
}