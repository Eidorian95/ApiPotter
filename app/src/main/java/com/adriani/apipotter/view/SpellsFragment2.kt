package com.adriani.apipotter.view


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.adriani.apipotter.R
import com.adriani.apipotter.model.HpCharacter2
import com.adriani.apipotter.model.Spell
import com.adriani.apipotter.view.adapters.SpellAdapter
import com.adriani.apipotter.viewmodel.CharactersViewModel2
import com.adriani.apipotter.viewmodel.SpellsViewModel
import kotlinx.android.synthetic.main.fragment_characters_fragmet.*
import kotlinx.android.synthetic.main.fragment_spells.*

class SpellsFragment2 : Fragment() {

    companion object{
        fun newInstance():SpellsFragment2 = SpellsFragment2()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_spells, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel: SpellsViewModel = ViewModelProviders.of(this).get(SpellsViewModel::class.java)

        viewModel.isLoading.observe(this, Observer<Boolean> {
            it?.let{showLoading(it)}
        })

            viewModel.getSpells().observe(this, Observer<List<Spell>> { spells ->
                if (!spells.isNullOrEmpty()) {
                    setRecyclerView(spells)
                }
            })

    }


    private fun setRecyclerView(spellList:List<Spell>){
        spells_list.layoutManager = LinearLayoutManager(activity)
        spells_list.hasFixedSize()
        spells_list.adapter = SpellAdapter(spellList)
        spells_list.visibility = View.VISIBLE
    }

    private fun showLoading(loading: Boolean) {
        when {
            loading -> progressBar_spells.visibility = View.VISIBLE
            else -> progressBar_spells.visibility = View.GONE
        }
    }


}
