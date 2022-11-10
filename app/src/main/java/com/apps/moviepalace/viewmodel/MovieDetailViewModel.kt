package com.apps.moviepalace.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.apps.moviepalace.api.MovieRepository
import com.apps.moviepalace.model.MovieDetail
import javax.inject.Inject

class MovieDetailViewModel  @Inject constructor(private val movieRepository: MovieRepository): ViewModel()  {




    fun getMovieDetails(): LiveData<MovieDetail> {
        return  movieRepository.getMovieDetails()
    }

    fun detailCall(query: String?){
        movieRepository.detailCall(query!!)
    }
}