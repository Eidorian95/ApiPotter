package com.adriani.apipotter.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.adriani.apipotter.model.HpCharacter2
import com.adriani.apipotter.repository.ApiRepository2

class CharactersViewModel2 : ViewModel() {

    private lateinit var charactersList: MutableLiveData<List<HpCharacter2>>
    private var repo:ApiRepository2 = ApiRepository2()
    var isLoading = MutableLiveData<Boolean>()


    fun getCharacters():LiveData<List<HpCharacter2>>{
        if(!::charactersList.isInitialized){
            loadCharacters()
        }
        return charactersList
    }

    private fun loadCharacters() {
        charactersList = MutableLiveData()
        isLoading.value = true

        repo.getAllCharacters({
            charactersList.value = it
            isLoading.value = false

        },{
            Log.d("API_ERROR", it.message)
            isLoading.value = false
        })
    }


}