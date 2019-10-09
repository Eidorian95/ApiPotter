package com.adriani.apipotter.Repository

import com.adriani.apipotter.Model.Character
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiPotterService {

    @GET("characters/?key=$2a$10$1zhUrjo/Q3FHsk2mh6tfZ.YvMEGNuR2PTCpTFMeF1k09yN1hSEzl.")
    fun getAllCharacters(): Call<List<Character>>

}