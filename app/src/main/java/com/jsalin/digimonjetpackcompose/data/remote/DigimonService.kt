package com.jsalin.digimonjetpackcompose.data.remote

import com.jsalin.digimonjetpackcompose.data.remote.model.DigimonModelItem
import com.jsalin.digimonjetpackcompose.data.remote.model.DigimonsModel
import com.jsalin.digimonjetpackcompose.util.BASE_URL
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DigimonService {

    fun getDigimon(success: (digimonList: List<DigimonModelItem>) -> Unit, failure: () -> Unit) {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(DigimonApi::class.java)

        service.getDigimons().enqueue(object: Callback<DigimonsModel> {
            override fun onResponse(call: Call<DigimonsModel>, response: Response<DigimonsModel>) {
                success(response.body() ?: listOf())
            }

            override fun onFailure(call: Call<DigimonsModel>, t: Throwable) {
                failure()
            }
        })
    }
}