package com.apps.moviepalace.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.RecyclerView
import com.apps.moviepalace.R
import com.apps.moviepalace.model.Movie
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.movie_item.view.*
import java.lang.reflect.Type

class RecyclerViewAdapter(): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    private var movies: List<Movie>? = null
    fun setMovies(movies: List<Movie>?){
        this.movies = movies
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):RecyclerViewAdapter.ViewHolder{
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)

        return ViewHolder(view)
    }


    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val poster_path = view.poster_path
        val original_title = view.original_title
        val release_date = view.release_date
        fun bind(movie: Movie){

            original_title.text = movie.original_title
            release_date.text = movie.release_date

            Glide.with(poster_path)
                .load(movie.poster_path)
                .into(poster_path)



        }

    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.ViewHolder, position: Int){
        holder.bind(movies?.get(position)!!)
    }

    override fun getItemCount(): Int {
        return  movies?.size!!
    }
}