package com.adriani.apipotter.view.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.adriani.apipotter.Model.HpCharacter
import com.adriani.apipotter.R
import kotlinx.android.synthetic.main.template_characters.view.*

class CharactersAdapter(val characters:List<HpCharacter>, private val itemClickListener: OnItemClickListener):RecyclerView.Adapter<CharactersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.template_characters, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return characters.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bindItems(characters.get(position),itemClickListener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(character: HpCharacter, itemClickListener: OnItemClickListener) {
            itemView.character_name.text = character.name
            itemView.setOnClickListener{itemClickListener.onItemClicked(character)}
        }
    }


    interface OnItemClickListener{
        fun onItemClicked(character: HpCharacter?)
    }
}