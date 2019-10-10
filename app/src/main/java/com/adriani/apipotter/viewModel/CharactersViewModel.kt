package com.adriani.apipotter.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.adriani.apipotter.Model.HpCharacter
import com.adriani.apipotter.Repository.ApiRepository

class CharactersViewModel : ViewModel() {

    private lateinit var charactersList: MutableLiveData<List<HpCharacter>>
    private var repo:ApiRepository = ApiRepository()
    var isLoading = MutableLiveData<Boolean>()


    fun getCharacters():LiveData<List<HpCharacter>>{
        if(!::charactersList.isInitialized){
            findCharacter()
        }
        return charactersList
    }

    private fun findCharacter() {
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