package com.jcn.listadefilmes.data

class MoviesRepository(private val moviesDataSource: MoviesDataSource) {
    fun getAllMoviesFromDataSource() = moviesDataSource.getAllMovies()
}