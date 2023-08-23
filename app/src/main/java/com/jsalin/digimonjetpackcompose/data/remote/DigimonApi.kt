package com.jsalin.digimonjetpackcompose.data.remote

import com.jsalin.digimonjetpackcompose.data.remote.model.DigimonsModel
import retrofit2.Call
import retrofit2.http.GET

interface DigimonApi {

    @GET("digimon/")
    fun getDigimons(
    ): Call<DigimonsModel>
}