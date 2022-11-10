package com.apps.moviepalace.model

data class MovieDetail (
    val adult: Boolean,
    val backdropPath: String?,
    val budget: Int,
    val homepage: String?,
    val id: Int,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
)