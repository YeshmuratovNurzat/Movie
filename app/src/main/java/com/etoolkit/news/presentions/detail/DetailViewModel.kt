package com.etoolkit.news.presentions.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.etoolkit.news.domian.model.MovieItem

class DetailViewModel : ViewModel(){

    val liveDataMovie = MutableLiveData<MovieItem>()

}