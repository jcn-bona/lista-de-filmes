package com.jcn.listadefilmes.repository

import android.util.Log
import com.jcn.listadefilmes.api.MoviesRestApiTask
import com.jcn.listadefilmes.model.Movie

class MoviesRepository(private val moviesRestApiTask: MoviesRestApiTask) {
    companion object { const val TAG = "MoviesRepository" }

    private val moviesList = arrayListOf<Movie>()

    fun getAllMovies(): List<Movie> {
        // Busca os filmes na nuvem
        val request = moviesRestApiTask.retrofitApi().getAllMovies().execute()

        if (request.isSuccessful) {
            request.body()?.let {
                moviesList.addAll(it) // retorna toda lista de filme
            }
        } else {
            //Como pode retornar null, let garante que esse null não gerará erro
            request.errorBody()?.let {
                Log.d(TAG, it.toString())
            }
        }
        return moviesList
    }
}