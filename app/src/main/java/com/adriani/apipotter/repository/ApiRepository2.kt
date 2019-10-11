package com.adriani.apipotter.repository

import com.adriani.apipotter.model.HpCharacter2
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ApiRepository2 {

    private val KEY: String = "$2a$10$1zhUrjo/Q3FHsk2mh6tfZ.YvMEGNuR2PTCpTFMeF1k09yN1hSEzl."
    private val retrofit = RetrofitService2.getRetrofit

    fun getAllCharacters(success: (List<HpCharacter2>) -> Unit, failure: (Throwable) -> Unit) {
        var charac: Call<List<HpCharacter2>> = retrofit.getAllCharacters(KEY)
        charac.enqueue(object : Callback<List<HpCharacter2>>{
            override fun onFailure(call: Call<List<HpCharacter2>>, t: Throwable) {
               failure(t)
            }
            override fun onResponse(call: Call<List<HpCharacter2>>, response: Response<List<HpCharacter2>>) {
               success(response.body()!!)
            }
        })
    }
}