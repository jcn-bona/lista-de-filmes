package com.jcn.listadefilmes.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jcn.listadefilmes.api.MoviesRestApiTask
import com.jcn.listadefilmes.model.Movie
import com.jcn.listadefilmes.repository.MoviesRepository

class MovieListViewModel: ViewModel() {
    companion object { const val TAG = "MoviesRepository" }
    private val moviesRestApiTask = MoviesRestApiTask()
    private val moviesRepository = MoviesRepository(moviesRestApiTask)
    private var _moviesList = MutableLiveData<List<Movie>>()
    val moviesList: LiveData<List<Movie>> get() = _moviesList

    fun init() = getAllMovies()

    private fun getAllMovies() {
        Thread {
            try {
                _moviesList.postValue(moviesRepository.getAllMovies())
            } catch (e: Exception) {
                Log.d(TAG, e.message.toString())
            }
        }.start()
    }
}