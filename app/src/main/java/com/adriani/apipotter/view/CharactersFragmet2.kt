package com.adriani.apipotter.view


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.adriani.apipotter.model.HpCharacter2

import com.adriani.apipotter.R
import com.adriani.apipotter.view.adapters.CharactersAdapter2
import com.adriani.apipotter.viewmodel.CharactersViewModel2
import kotlinx.android.synthetic.main.fragment_characters_fragmet.*

class CharactersFragmet2 : Fragment() {

    private lateinit var viewModel2: CharactersViewModel2

    companion object{
        fun newInstance():CharactersFragmet2 = CharactersFragmet2()
    }

    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_characters_fragmet, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel2 = ViewModelProviders.of(this).get(CharactersViewModel2::class.java)

        viewModel2.isLoading.observe(this, Observer<Boolean> {
            it?.let{showLoading(it)}
        })

        viewModel2.getCharacters().observe(this, Observer<List<HpCharacter2>>{ char ->
            if(char!!.isNotEmpty()){
               setRecyclerView(char)
            }
        })
    }

    private fun setRecyclerView(characters:List<HpCharacter2>){
        characters_list.layoutManager = LinearLayoutManager(activity)
        characters_list.hasFixedSize()
        characters_list.adapter = CharactersAdapter2(characters)
        characters_list.visibility = View.VISIBLE
    }

    private fun showLoading(loading:Boolean){
        when {
            loading -> progressBar_character.visibility = View.VISIBLE
            else -> progressBar_character.visibility = View.GONE
        }
    }

}
