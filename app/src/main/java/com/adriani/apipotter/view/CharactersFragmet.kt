package com.adriani.apipotter.view


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.adriani.apipotter.R
import com.adriani.apipotter.Repository.CharacterRepository

class CharactersFragmet : Fragment() {

    companion object{
        fun newInstance():CharactersFragmet = CharactersFragmet()
    }

    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_characters_fragmet, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var repo = CharacterRepository()

        repo.getAllCharacters({
            Log.d("RESPONSE", it.toString())
        }, {
            Log.d("ERROR", it.message)
        })
    }
}
