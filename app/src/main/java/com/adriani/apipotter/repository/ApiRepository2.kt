package com.adriani.apipotter.repository

import com.adriani.apipotter.model.HpCharacter2
import com.adriani.apipotter.model.Spell
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ApiRepository2 {

    private val KEY: String = "$2a$10$1zhUrjo/Q3FHsk2mh6tfZ.YvMEGNuR2PTCpTFMeF1k09yN1hSEzl."
    private val retrofit = RetrofitService2.getRetrofit

    fun getAllCharacters(success: (List<HpCharacter2>) -> Unit, failure: (Throwable) -> Unit) {
        val characters: Call<List<HpCharacter2>> = retrofit.getAllCharacters(KEY)
        characters.enqueue(object : Callback<List<HpCharacter2>>{
            override fun onFailure(call: Call<List<HpCharacter2>>, t: Throwable) {
               failure(t)
            }
            override fun onResponse(call: Call<List<HpCharacter2>>, response: Response<List<HpCharacter2>>) {
               success(response.body()!!)
            }
        })
    }


    fun getAllSpells(success: (List<Spell>) -> Unit, failure: (Throwable) -> Unit){
        val spells:Call<List<Spell>> = retrofit.getAllSpells(KEY)
        spells.enqueue(object : Callback<List<Spell>>{
            override fun onFailure(call: Call<List<Spell>>, t: Throwable) {
               failure(t)
            }
            override fun onResponse(call: Call<List<Spell>>, response: Response<List<Spell>>) {
                success(response.body()!!)
            }
        })
    }
}