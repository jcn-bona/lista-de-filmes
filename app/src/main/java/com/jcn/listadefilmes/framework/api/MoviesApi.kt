package com.jcn.listadefilmes.framework.api

import com.jcn.listadefilmes.domain.Movie
import retrofit2.Call
import retrofit2.http.GET

interface MoviesApi {

    @GET("natanfelipe/FilmesFlixJson/master/moviesList")
    fun getAllMovies(): Call<List<Movie>>
}