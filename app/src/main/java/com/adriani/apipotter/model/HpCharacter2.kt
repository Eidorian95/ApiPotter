package com.adriani.apipotter.model


import com.google.gson.annotations.SerializedName

data class HpCharacter2(
    @SerializedName("bloodStatus")
    val bloodStatus: String,
    @SerializedName("deathEater")
    val deathEater: Boolean,
    @SerializedName("dumbledoresArmy")
    val dumbledoresArmy: Boolean,
    @SerializedName("house")
    val house: String,
    @SerializedName("_id")
    val id: String,
    @SerializedName("ministryOfMagic")
    val ministryOfMagic: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("orderOfThePhoenix")
    val orderOfThePhoenix: Boolean,
    @SerializedName("role")
    val role: String,
    @SerializedName("school")
    val school: String,
    @SerializedName("species")
    val species: String,
    @SerializedName("__v")
    val v: Int
)