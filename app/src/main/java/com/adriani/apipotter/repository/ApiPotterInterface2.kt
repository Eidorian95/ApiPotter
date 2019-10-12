package com.adriani.apipotter.repository

import com.adriani.apipotter.model.HpCharacter2
import com.adriani.apipotter.model.Spell
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiPotterInterface2 {

    @GET("characters/")
    fun getAllCharacters(@Query ("key") apiKey:String): Call<List<HpCharacter2>>

    @GET("spells/")
    fun getAllSpells(@Query ("key") apiKey:String): Call<List<Spell>>


}