package com.apps.moviepalace.api

import androidx.lifecycle.LiveData
import com.apps.moviepalace.model.Movie
import com.apps.moviepalace.model.MovieDetail
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
    fun getMovieDetails(): LiveData<MovieDetail>{
        return  roomDao.getMovieDetails()
    }
    fun insertMovieDetail(movieDetail: MovieDetail){
        roomDao.insertMovieDetail(movieDetail)
    }
    fun apiCall(query: Int?){
        val call: Call<MoviesList> = apiInterface.getMovies(query!!)
        call.enqueue(object :Callback<MoviesList>{
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
    fun detailCall(path:String?,query: String?){
        val call: Call<MovieDetail> = apiInterface.getMovieDetails(path!!,query!!)
        call.enqueue(object :Callback<MovieDetail>{
            override fun onResponse(
                call: Call<MovieDetail>,
                response: Response<MovieDetail>
            ){
                if (response.isSuccessful){
                    response.body()?.let { insertMovieDetail(it) }
                }
            }

            override fun onFailure(call: Call<MovieDetail>, t: Throwable) {
            }

        })
    }



}