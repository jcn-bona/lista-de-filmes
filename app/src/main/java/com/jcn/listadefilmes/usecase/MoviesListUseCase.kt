package com.jcn.listadefilmes.usecase

import com.jcn.listadefilmes.data.MoviesRepository

class MoviesListUseCase(private val moviesRepository: MoviesRepository) {
    operator fun invoke() = moviesRepository.getAllMoviesFromDataSource()
}