package com.jcn.listadefilmes.api

import com.jcn.listadefilmes.model.Movie
import retrofit2.Call
import retrofit2.http.GET

interface MoviesApi {

    @GET("natanfelipe/FilmesFlixJson/master/moviesList")
    fun getAllMovies(): Call<List<Movie>>
}