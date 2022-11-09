package com.apps.moviepalace.hilt

import android.app.Application
import com.apps.moviepalace.api.ApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class App {
    @Provides
    @Singleton
    fun getMovieDatabase(){

    }
    fun getMovieDao(){

    }

    val BASE_URL = "https://api.themoviedb.org/3/movie/"

    @Provides
    @Singleton
    fun getApiInterface(retrofit: Retrofit): ApiInterface{
        return retrofit.create(ApiInterface::class.java)
    }
    @Provides
    @Singleton
    fun getApiInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }


}