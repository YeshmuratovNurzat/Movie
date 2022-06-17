package com.etoolkit.news.data.room

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class MovieDataBase : RoomDatabase() {

    abstract fun movieDao() : MovieDao

    companion object {

        private var instance: MovieDataBase? = null

        @Synchronized
        fun getInstance(context: Context): MovieDataBase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext, MovieDataBase::class.java,
                    "movie_database")
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance!!
        }
    }
}