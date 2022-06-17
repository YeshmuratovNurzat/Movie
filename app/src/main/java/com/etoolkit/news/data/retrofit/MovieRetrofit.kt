package com.etoolkit.news.data.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MovieRetrofit {

    private val BASE_URL = "https://api.themoviedb.org/"

    fun create() : MovieApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(MovieApiService::class.java)
    }

}