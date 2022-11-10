package com.apps.moviepalace

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.apps.moviepalace.viewmodel.MovieDetailViewModel

class MovieDetailActivity : AppCompatActivity() {

    lateinit var titletxt: TextView
    lateinit var overviewtxt: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        titletxt = findViewById(R.id.title)
        overviewtxt = findViewById(R.id.overview)


        initViewModel()
    }
    fun initViewModel(){
        val viewModel =  ViewModelProvider(this).get(MovieDetailViewModel::class.java)
        viewModel.getMovieDetails().observe(this, Observer {
            titletxt.text = it.originalTitle
            overviewtxt.text = it.overview
        } )
    }
}