package com.etoolkit.news.domian.model

import androidx.room.Entity

@Entity(tableName = "movie")
data class Movie(
    val page: Int,
    val results: List<MovieItem>,
    val total_pages: Int,
    val total_results: Int
)