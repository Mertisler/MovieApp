package com.loc.movie_app.presentation.movie_detail

import com.loc.movie_app.domain.model.MovieDetail

data class MovieDetailState(
    val isLoading : Boolean = false,
    val movie : MovieDetail? = null,
    val error : String = ""
)