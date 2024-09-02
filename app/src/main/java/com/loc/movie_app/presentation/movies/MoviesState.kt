package com.loc.movie_app.presentation.movies

import com.loc.movie_app.domain.model.Movie

data class MoviesState(
    val isLoading : Boolean = false,
    val movies : List<Movie> = emptyList(),
    val error : String = "",
    val search : String = "game of thrones"
)