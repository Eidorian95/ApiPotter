package com.adriani.apipotter.Repository

import com.adriani.apipotter.Model.Character
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CharacterRepository {

    private val KEY: String = "$2a$10$1zhUrjo/Q3FHsk2mh6tfZ.YvMEGNuR2PTCpTFMeF1k09yN1hSEzl."

    fun getAllCharacters(success: (List<Character>) -> Unit, failure: (Throwable) -> Unit) {
        var charac: Call<List<Character>> = RetrofitService.getRetrofit.getAllCharacters()

        charac.enqueue(object : Callback<List<Character>>{
            override fun onFailure(call: Call<List<Character>>, t: Throwable) {
               failure(t)
            }

            override fun onResponse(call: Call<List<Character>>, response: Response<List<Character>>) {
               success(response.body()!!)
            }
        })


}


}