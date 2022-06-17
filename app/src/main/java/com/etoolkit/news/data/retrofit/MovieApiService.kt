package com.etoolkit.news.data.retrofit

import com.etoolkit.news.domian.model.Movie
import retrofit2.Response
import retrofit2.http.GET

interface MovieApiService {

    @GET("3/movie/top_rated?api_key=9436475b8f71cc75007908b137b5f23d&language=en-US&page=1")
    suspend fun getTopRatedMovie() : Response<Movie>

}