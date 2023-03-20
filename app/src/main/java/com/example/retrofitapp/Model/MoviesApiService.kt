package com.example.retrofitapp.Model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MoviesApiService {

    var BASE_URL = "https://api.themoviedb.org"

    var retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MovieApi::class.java)


    fun getPopularMovies() = retrofit.getPopularMovie()

    fun getTopMovies() = retrofit.getTopMovies()

    fun getUpcomingMovies() = retrofit.getUpcomingMovies()



}
