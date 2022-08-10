package com.jcn.listadefilmes.framework.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jcn.listadefilmes.framework.api.MoviesRestApiTask
import com.jcn.listadefilmes.domain.Movie
import com.jcn.listadefilmes.data.MoviesRepository
import com.jcn.listadefilmes.implementations.MoviesDataSourceImplementation
import com.jcn.listadefilmes.usecase.MoviesListUseCase

class MovieListViewModel: ViewModel() {
    companion object { const val TAG = "MoviesRepository" }
    private val moviesRestApiTask = MoviesRestApiTask()
    private val moviesDataSource = MoviesDataSourceImplementation(moviesRestApiTask)
    private val moviesRepository = MoviesRepository(moviesDataSource)
    private val moviesListUseCase = MoviesListUseCase(moviesRepository)

    private var _moviesList = MutableLiveData<List<Movie>>()
    val moviesList: LiveData<List<Movie>> get() = _moviesList

    fun init() = getAllMovies()

    private fun getAllMovies() {
        Thread {
            try {
                _moviesList.postValue(moviesListUseCase.invoke())
            } catch (e: Exception) {
                Log.d(TAG, e.message.toString())
            }
        }.start()
    }
}