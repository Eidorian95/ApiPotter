package com.adriani.apipotter.Repository

import com.adriani.apipotter.Model.HpCharacter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ApiRepository {

    private val KEY: String = "$2a$10$1zhUrjo/Q3FHsk2mh6tfZ.YvMEGNuR2PTCpTFMeF1k09yN1hSEzl."

    fun getAllCharacters(success: (List<HpCharacter>) -> Unit, failure: (Throwable) -> Unit) {
        var charac: Call<List<HpCharacter>> = RetrofitService.getRetrofit.getAllCharacters(KEY)

        charac.enqueue(object : Callback<List<HpCharacter>>{
            override fun onFailure(call: Call<List<HpCharacter>>, t: Throwable) {
               failure(t)
            }

            override fun onResponse(call: Call<List<HpCharacter>>, response: Response<List<HpCharacter>>) {
               success(response.body()!!)
            }
        })


}


}