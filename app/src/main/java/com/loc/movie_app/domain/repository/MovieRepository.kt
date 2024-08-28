package com.loc.movie_app.domain.repository

import com.loc.movie_app.data.remote.dto.MovieDetailDto
import com.loc.movie_app.data.remote.dto.MoviesDto

interface MovieRepository {
    suspend fun getMovies(search:String):MoviesDto
    suspend fun getMovieDetail(imdbId:String):MovieDetailDto
}