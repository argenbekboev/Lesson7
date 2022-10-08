package com.example.lesson7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lesson7.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    private lateinit var bundle: Bundle

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logic()
    }

    private fun logic() {
        val tvName = arguments?.getString(MainFragment.KFN)
        val tvLife = arguments?.getString(MainFragment.KFL)
        val tvPictures = arguments?.getString(MainFragment.KFP)
        binding.tvTx.text = tvName
        binding.txTv.text = tvLife
        tvPictures?.let {
            binding.imgPhoto.loadWithGlide(it)
        }
    }
}