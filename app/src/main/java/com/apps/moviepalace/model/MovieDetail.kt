package com.apps.moviepalace.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movieDetail")
data class MovieDetail (
    val adult: Boolean,
    val backdropPath: String?,
    val budget: Int,
    val homepage: String?,
    @PrimaryKey
    val id: Int,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
)