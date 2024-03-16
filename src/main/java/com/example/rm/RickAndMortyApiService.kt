package com.example.rm

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitServices {
    @GET(RickAndMortyApp.CHARACTERS_ENDPOINT)
    suspend fun getResponse() : CharacterResponse
}

class RetrofitClient {
    companion object {
        fun createService(): RetrofitServices {
            val retrofit = Retrofit.Builder()
                .baseUrl(RickAndMortyApp.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(RetrofitServices::class.java)
        }
    }
}