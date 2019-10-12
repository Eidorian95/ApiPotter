package com.adriani.apipotter.model


import com.google.gson.annotations.SerializedName

data class Spell(
    @SerializedName("effect")
    val effect: String,
    @SerializedName("_id")
    val id: String,
    @SerializedName("spell")
    val name: String,
    @SerializedName("type")
    val type: String
)