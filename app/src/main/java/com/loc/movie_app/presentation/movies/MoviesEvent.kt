package com.loc.movie_app.presentation.movies


sealed class MoviesEvent {
    data class Search(val searchString :String) : MoviesEvent()

}