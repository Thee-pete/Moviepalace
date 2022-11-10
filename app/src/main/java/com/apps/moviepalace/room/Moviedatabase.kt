package com.apps.moviepalace.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.apps.moviepalace.model.Movie
import com.apps.moviepalace.model.MovieDetail

@Database(entities = [Movie::class, MovieDetail::class], version = 1,exportSchema = false)
abstract class Moviedatabase: RoomDatabase() {

    abstract fun movieDao(): RoomDao

    companion object{
        private var INSTANCE : Moviedatabase?= null
        fun getDatabase(context : Context): Moviedatabase{
            if (INSTANCE == null){
                INSTANCE = Room.databaseBuilder(context.applicationContext, Moviedatabase::class.java, "MOVIE_DB")
                    .allowMainThreadQueries()
                    .build()

            }
            return  INSTANCE!!
        }

    }
}