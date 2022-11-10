package com.apps.moviepalace.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.apps.moviepalace.api.MovieRepository
import com.apps.moviepalace.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val movieRepository: MovieRepository): ViewModel() {

    fun getMoviesList(): LiveData<List<Movie>>{
        return movieRepository.getMovies()
    }
//f146b5c490bfc0a759924c0dc94b96f6
    fun apiCall(){
        movieRepository.apiCall("f146b5c490bfc0a759924c0dc94b96f6")
    }

}