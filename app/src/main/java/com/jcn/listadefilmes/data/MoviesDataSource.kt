package com.jcn.listadefilmes.data

import com.jcn.listadefilmes.domain.Movie

interface MoviesDataSource { fun getAllMovies(): List<Movie> }