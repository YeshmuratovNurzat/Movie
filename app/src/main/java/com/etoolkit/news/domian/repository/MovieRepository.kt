package com.etoolkit.news.domian.repository

import com.etoolkit.news.domian.model.Movie
import com.etoolkit.news.domian.model.MovieItem
import retrofit2.Response

interface MovieRepository {

    suspend fun getDataApi() : Response<Movie>

    suspend fun insert(movie: Movie)

    suspend fun delete(movie: Movie)

}