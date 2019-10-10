package com.adriani.apipotter.Repository

import com.adriani.apipotter.Model.HpCharacter
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiPotterInterface {

    @GET("characters/")
    fun getAllCharacters(@Query ("key") apiKey:String): Call<List<HpCharacter>>

}