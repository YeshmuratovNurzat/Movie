package com.etoolkit.news.presentions.home


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.etoolkit.news.data.repositoryImpl.MovieRepositoryImpl
import com.etoolkit.news.domian.model.Movie
import kotlinx.coroutines.launch
import retrofit2.Response

class HomeViewModel() : ViewModel() {

    val getAllMovieLiveData = MutableLiveData<Response<Movie>>()
    private val repository = MovieRepositoryImpl()

    fun getAllData(){

        viewModelScope.launch {
            getAllMovieLiveData.value = repository.getDataApi()
        }
    }




}