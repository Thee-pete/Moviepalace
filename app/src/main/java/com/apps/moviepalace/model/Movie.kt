package com.apps.moviepalace.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class Movie (
    @PrimaryKey
    val id : String,
    val original_title : String,
    val poster_path : String,
    val release_date:String
)