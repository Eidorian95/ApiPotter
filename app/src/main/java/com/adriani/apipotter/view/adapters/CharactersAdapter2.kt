package com.adriani.apipotter.view.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.adriani.apipotter.model.HpCharacter2
import com.adriani.apipotter.databinding.TemplateCharactersBinding

class CharactersAdapter2(private val character2s:List<HpCharacter2>):RecyclerView.Adapter<CharactersAdapter2.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TemplateCharactersBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return character2s.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bindItems(character2s[position])
    }


    class ViewHolder(private val binding: TemplateCharactersBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindItems(character: HpCharacter2) {
            binding.hpCharacter2 = character
            binding.executePendingBindings()
        }
    }

}