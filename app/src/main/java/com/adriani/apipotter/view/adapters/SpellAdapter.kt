package com.adriani.apipotter.view.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.adriani.apipotter.model.HpCharacter2
import com.adriani.apipotter.databinding.TemplateCharactersBinding
import com.adriani.apipotter.databinding.TemplateSpellsBinding
import com.adriani.apipotter.model.Spell

class SpellAdapter(private val spells:List<Spell>):RecyclerView.Adapter<SpellAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TemplateSpellsBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return spells.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bindItems(spells[position])
    }


    class ViewHolder(private val binding: TemplateSpellsBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindItems(spell: Spell) {
            binding.spell = spell
            binding.executePendingBindings()
        }
    }

}