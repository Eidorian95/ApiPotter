package com.adriani.apipotter.repository

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService2 {

    private const val BASE_URL = "https://www.potterapi.com/v1/"

    val getRetrofit: ApiPotterInterface2
        get() {
            val gson = GsonBuilder()
                .setLenient()
                .create()
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

            return retrofit.create(ApiPotterInterface2::class.java)
        }

}
