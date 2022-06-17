package com.etoolkit.news.data.room

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.etoolkit.news.domian.model.Movie
import com.etoolkit.news.domian.model.MovieItem
import retrofit2.Response

interface MovieDao {

    @Query("SELECT * FROM movie" )
    fun getAllAstronomyPicture() : List<Movie>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(movie : Movie)

    @Delete
    fun delete(movie : Movie)
}