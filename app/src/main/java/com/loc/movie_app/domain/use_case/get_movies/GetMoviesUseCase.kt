package com.loc.movie_app.domain.use_case.get_movies

import coil.network.HttpException
import com.loc.movie_app.data.remote.dto.toMovieList
import com.loc.movie_app.domain.model.Movie
import com.loc.movie_app.domain.repository.MovieRepository
import com.loc.movie_app.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOError
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(private val repository: MovieRepository) {
    fun executeGetMovies(search:String):Flow<Resource<List<Movie>>> = flow {
        try {
            emit(Resource.Loading())
            val movieList=repository.getMovies(search)
            if (movieList.Response.equals(true)){
                emit(Resource.Success(movieList.toMovieList()))
            }else{
                emit(Resource.Error(message = "hata oluştu"))
            }

        }catch (e:IOError){
            emit(Resource.Error(message = "internet bağlantısında hata oluştu"))
        }
        catch (e: HttpException){
            emit(Resource.Error(message = e.localizedMessage ?: "error"))
        }

    }
}