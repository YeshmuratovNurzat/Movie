package com.etoolkit.news.presentions.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.etoolkit.news.R
import com.etoolkit.news.domian.model.MovieItem

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    private var listMovie = emptyList<MovieItem>()
    private lateinit var clickListener : SetClickListener

    class HomeViewHolder(view : View) : RecyclerView.ViewHolder(view){

        private val imageItemMovie = view.findViewById<ImageView>(R.id.imageItemMovie)
        private val titleItemMovie = view.findViewById<TextView>(R.id.titleItemMovie)
        private val dateItemMovie = view.findViewById<TextView>(R.id.dateItemMovie)

        fun bind(movie : MovieItem){

            titleItemMovie.text = movie.title
            dateItemMovie.text = movie.release_date

            Glide.with(this.imageItemMovie)
                .load("https://www.themoviedb.org/t/p/w600_and_h900_bestv2${movie.poster_path}")
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .placeholder(R.drawable.img)
                .into(imageItemMovie)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_home,parent,false)
        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(listMovie[position])

        holder.itemView.setOnClickListener {
            clickListener.onClick(listMovie[position])
        }
    }

    override fun getItemCount(): Int {
        return listMovie.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setDataList(listMovie: List<MovieItem>){
        this.listMovie = listMovie
        notifyDataSetChanged()
    }

    interface SetClickListener{
        fun onClick(movie: MovieItem)
    }

    fun setOnClick(setClickListener : SetClickListener){
        clickListener = setClickListener
    }

}