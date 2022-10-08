package com.example.lesson7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.lesson7.databinding.FragmentMainBinding

class MainFragment : Fragment() {


    private lateinit var binding: FragmentMainBinding
    private lateinit var adapter: AnimationAdapter
    private lateinit var data: ArrayList<Characters>
    private lateinit var navController: NavController

    companion object {
        const val KFN: String = "KEY_FOR_NAME"
        const val KFL: String = "KEY_FOR_LIFE"
        const val KFP: String = "KEY_FOR_PICTURES"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
        adapter = AnimationAdapter(data, this::onClick)
        binding.recycler1.adapter = adapter

    }

    private fun loadData() {
        data = ArrayList()
        data.apply {

        add(Characters("Rick Sanchez" ,"https://static.wikia.nocookie.net/rickandmorty/images/a/a6/Rick_Sanchez.png/revision/latest?cb=20160923150728",  "Alive"))
        add(Characters("Morty Smith" ,"https://static.wikia.nocookie.net/rickandmorty/images/1/17/Mechanical_Morty.png/revision/latest?cb=20170731155031", "Alive"))
        add(Characters("Albert Einstein" ,"https://static.wikia.nocookie.net/rickandmorty/images/b/bc/Albert_Einstein.png/revision/latest?cb=20150730213810", "Dead"))
        add(Characters("Jerry Smith" ,"https://static.wikia.nocookie.net/rickandmorty/images/f/f1/Jerry_Smith.png/revision/latest?cb=20160923151111", "Alive"))
    }
    }

    private fun onClick(characters: Characters) {
        val bundle = Bundle()
        bundle.putString(KFN , characters.name)
        bundle.putString(KFL , characters.life)
        bundle.putString(KFP , characters.picture)
        val secondFragment = SecondFragment()
        secondFragment.arguments = bundle
        findNavController().navigate(R.id.secondFragment , bundle)

    }
}