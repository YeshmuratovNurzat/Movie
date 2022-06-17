package com.etoolkit.news.presentions.detail


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.etoolkit.news.R
import com.etoolkit.news.databinding.FragmentDetailBinding
import com.etoolkit.news.domian.model.MovieItem
import com.etoolkit.news.presentions.main.MAIN


class DetailFragment : Fragment() {


    private lateinit var binding : FragmentDetailBinding
    private lateinit var movieItem : MovieItem
    private lateinit var viewModel: DetailViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        binding = FragmentDetailBinding.inflate(layoutInflater,container,false)

        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

        movieItem = arguments?.getSerializable("movie") as MovieItem

        viewModel.liveDataMovie.value = movieItem

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.liveDataMovie.observe(viewLifecycleOwner,{
            setMovieItem(it)
        })

    }

    companion object {
        fun newInstance() = DetailFragment()
    }


    @JvmName("setMovieItem1")
    fun setMovieItem(movie : MovieItem){

        Glide.with(MAIN)
            .load("https://www.themoviedb.org/t/p/w600_and_h900_bestv2${movie.poster_path}")
            .optionalCircleCrop()
            .placeholder(R.drawable.img)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .into(binding.imageMovieDetail)

        binding.titleMovieDetail.text = movie.title
        binding.dateMovieDetail.text = movie.release_date
        binding.descriptionMovieDetail.text = movie.overview

        activity?.title = movie.title
    }
}