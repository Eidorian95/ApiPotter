package com.adriani.apipotter.model


import com.google.gson.annotations.SerializedName

data class House(
    @SerializedName("colors")
    val colors: List<String>,
    @SerializedName("founder")
    val founder: String,
    @SerializedName("headOfHouse")
    val headOfHouse: String,
    @SerializedName("houseGhost")
    val houseGhost: String,
    @SerializedName("_id")
    val id: String,
    @SerializedName("mascot")
    val mascot: String,
    @SerializedName("members")
    val members: List<String>,
    @SerializedName("name")
    val name: String,
    @SerializedName("school")
    val school: String,
    @SerializedName("__v")
    val v: Int,
    @SerializedName("values")
    val values: List<String>
)