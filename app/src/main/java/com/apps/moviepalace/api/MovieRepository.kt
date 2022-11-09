package com.apps.moviepalace.api

import androidx.lifecycle.LiveData
import com.apps.moviepalace.model.Movie
import com.apps.moviepalace.model.MoviesList
import com.apps.moviepalace.room.RoomDao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MovieRepository @Inject constructor(private val apiInterface: ApiInterface,
private val roomDao: RoomDao) {

    fun getMovies() : LiveData<List<Movie>>{
        return roomDao.getMovies()
    }
    fun insertMovies(movie: Movie){
        roomDao.insertMovies(movie)
    }

    fun apiCall(query: String?){
        val call: Call<MoviesList> = apiInterface.getMovies(query!!)
        call?.enqueue(object :Callback<MoviesList>{
            override fun onResponse(
                call: Call<MoviesList>,
                response: Response<MoviesList>
            ){
                if (response.isSuccessful){
                    response.body()?.movies?.forEach{
                        insertMovies(it)
                }

                }
            }

            override fun onFailure(call: Call<MoviesList>, t: Throwable) {

            }

        })
    }



}