package com.adriani.apipotter.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.adriani.apipotter.model.Spell
import com.adriani.apipotter.repository.ApiRepository2

class SpellsViewModel : ViewModel() {

    private var repo: ApiRepository2 = ApiRepository2()
    private var spells:MutableLiveData<List<Spell>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    fun getSpells():LiveData<List<Spell>>{
        loadSpells()
        return spells
    }

    private fun loadSpells() {
        spells = MutableLiveData()
        isLoading.value = true

        repo.getAllSpells({
            spells.value = it
            isLoading.value = false

        },{
            Log.d("API_ERROR", it.message)
            isLoading.value = false
        })
    }


}