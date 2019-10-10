package com.adriani.apipotter.view


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.adriani.apipotter.Model.HpCharacter

import com.adriani.apipotter.R
import com.adriani.apipotter.Repository.ApiRepository
import com.adriani.apipotter.view.adapters.CharactersAdapter
import com.adriani.apipotter.viewModel.CharactersViewModel
import kotlinx.android.synthetic.main.fragment_characters_fragmet.*

class CharactersFragmet : Fragment(), CharactersAdapter.OnItemClickListener {

    private lateinit var viewModel: CharactersViewModel

    companion object{
        fun newInstance():CharactersFragmet = CharactersFragmet()
    }

    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_characters_fragmet, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(CharactersViewModel::class.java)

        viewModel.isLoading.observe(this, Observer<Boolean> {
            it?.let{showLoading(it)}
        })

        viewModel.getCharacters().observe(this, Observer<List<HpCharacter>>{ char ->
            if(char!!.isNotEmpty()){
                characters_list.layoutManager = LinearLayoutManager(activity)
                characters_list.hasFixedSize()
                characters_list.adapter = CharactersAdapter(char, this)
                characters_list.visibility = View.VISIBLE
            }
        })


    }

    private fun showLoading(loading:Boolean){
        when {
            loading -> progressBar_character.visibility = View.VISIBLE
            else -> progressBar_character.visibility = View.GONE

        }
    }

    override fun onItemClicked(character: HpCharacter?) {
        Toast.makeText(activity,"House: ${character?.house?:"Nothing"}",Toast.LENGTH_SHORT).show()
    }
}
