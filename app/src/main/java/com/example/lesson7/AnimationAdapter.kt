package com.example.lesson7

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson7.databinding.ItemCharactersBinding


class AnimationAdapter(private val data: ArrayList<Characters> , private val onClick: (Characters) -> Unit): RecyclerView.Adapter<AnimationAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemCharactersBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(characters: Characters) {
            binding.txTv.text = characters.name
            binding.tvTx.text = characters.life
            binding.imgPhoto.loadWithGlide(characters.picture)
            binding.root.setOnClickListener {
                onClick(characters)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemCharactersBinding = ItemCharactersBinding.inflate(
            LayoutInflater.from(parent.context) , parent , false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

}