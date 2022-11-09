package com.apps.moviepalace.api

import com.apps.moviepalace.model.MoviesList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("movie/popular")
    fun getMovies(@Query("")query: String): Call<MoviesList>
}