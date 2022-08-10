package com.jcn.listadefilmes.implementations

import android.util.Log
import com.jcn.listadefilmes.framework.api.MoviesRestApiTask
import com.jcn.listadefilmes.data.MoviesDataSource
import com.jcn.listadefilmes.domain.Movie

class MoviesDataSourceImplementation(private val movieRestApiTask: MoviesRestApiTask): MoviesDataSource {

    companion object { const val TAG = "MovieRepository" }
    private val movieList = arrayListOf<Movie>()

    override fun getAllMovies(): List<Movie> {
        val request = movieRestApiTask.retrofitApi().getAllMovies().execute()

        if (request.isSuccessful) {
            request.body()?.let {
                movieList.addAll(it)
            }
        } else {
            request.errorBody()?.let {
                Log.d(TAG, it.toString())
            }
        }
        return movieList
    }
}