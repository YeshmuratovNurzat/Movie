package com.etoolkit.news.data.repositoryImpl

import com.etoolkit.news.data.retrofit.MovieRetrofit
import com.etoolkit.news.data.room.MovieDataBase
import com.etoolkit.news.domian.model.Movie
import com.etoolkit.news.domian.model.MovieItem
import com.etoolkit.news.domian.repository.MovieRepository
import retrofit2.Response

class MovieRepositoryImpl() : MovieRepository{

    override suspend fun getDataApi(): Response<Movie> {
        return MovieRetrofit.create().getTopRatedMovie()
    }

    override suspend fun insert(movie: Movie) {

    }

    override suspend fun delete(movie: Movie) {

    }

}