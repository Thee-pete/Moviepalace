package com.apps.moviepalace.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class Movie (
    @PrimaryKey
    var id : String,
    var original_title : String,
    var poster_path : String,
    var release_date:String
)