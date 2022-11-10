package com.apps.moviepalace.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.RecyclerView
import com.apps.moviepalace.MovieDetailActivity
import com.apps.moviepalace.R
import com.apps.moviepalace.model.Movie
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.movie_item.view.*
import java.lang.reflect.Type

class RecyclerViewAdapter(val ctx: Context): RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    private var movies: List<Movie>? = null
    fun setMovies(movies: List<Movie>?){
        this.movies = movies
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):RecyclerViewAdapter.MyViewHolder{
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)

        return MyViewHolder(view)
    }


    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val poster_path = view.poster_path
        val original_title = view.original_title
        val release_date = view.release_date


    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.MyViewHolder, position: Int){
        //holder.bind(movies?.get(position)!!)

        val movie = movies?.get(position)

        if (movie != null) {
            holder.original_title.text = movie.original_title
        }
        if (movie != null) {
            holder.release_date.text = movie.release_date
        }

        if (movie != null) {
            Glide.with(holder.poster_path)
                .load(movie.poster_path)
                .into(holder.poster_path)
        }



        holder.itemView.setOnClickListener{
                val intent = Intent(ctx,MovieDetailActivity::class.java)
                val movieId:String = movie?.id.toString()
                intent.putExtra("movieId",movieId)
                ctx.startActivity(intent)
        }


    }

    override fun getItemCount(): Int {

        if (movies == null)return 0
        return  movies?.size!!
    }
}