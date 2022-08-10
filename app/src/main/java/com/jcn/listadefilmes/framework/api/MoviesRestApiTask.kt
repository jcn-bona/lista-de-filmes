package com.jcn.listadefilmes.framework.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MoviesRestApiTask {

    companion object { const val BASE_URL = "https://raw.githubusercontent.com/" }

    private fun moviesProvider(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun retrofitApi(): MoviesApi = moviesProvider().create(MoviesApi::class.java)
}