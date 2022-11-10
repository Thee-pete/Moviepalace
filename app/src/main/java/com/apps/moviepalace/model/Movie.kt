package com.apps.moviepalace.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class Movie (
    @PrimaryKey @ColumnInfo(name= "id")val id : String,
    @ColumnInfo(name= "original_title")val original_title : String,
    @ColumnInfo(name= "poster_path")val poster_path : String,
    @ColumnInfo(name= "release_date")val release_date:String
)