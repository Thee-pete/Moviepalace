package com.apps.moviepalace.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.apps.moviepalace.model.Movie
import com.apps.moviepalace.model.MovieDetail

@Dao
interface RoomDao {

    @Query("SELECT * FROM movies")
    fun getMovies(): LiveData<List<Movie>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movie : Movie)

    @Query("SELECT * FROM movieDetail")
    fun getMovieDetails(): LiveData<MovieDetail>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieDetail(movieDetail: MovieDetail)

}