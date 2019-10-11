package com.adriani.apipotter.repository

import com.adriani.apipotter.model.HpCharacter2
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiPotterInterface2 {

    @GET("characters/")
    fun getAllCharacters(@Query ("key") apiKey:String): Call<List<HpCharacter2>>

}