package com.apps.moviepalace.api

import com.apps.moviepalace.model.MovieDetail
import com.apps.moviepalace.model.MoviesList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val api_key = "f146b5c490bfc0a759924c0dc94b96f6"
interface ApiInterface {


    @GET("/popular?api_key=$api_key&language=en-US")
    fun getMovies(@Query("page")  page: Int): Call<MoviesList>
    @GET("3/movie/{movieId}?api_key=$api_key")
    fun getMovieDetails(@Path("movieId") movieId: String, @Query("language") language: String): Call<MovieDetail>

}