package com.example.retrofitapp.Model

import retrofit2.Call
import retrofit2.http.GET

interface MovieApi {

    @GET("/3/movie/popular?api_key=6ad27c9e3248c8d672ea8473485d727a")
    fun getPopularMovie() : Call<MoviesResponse>


    @GET("/3/movie/top_rated?api_key=6ad27c9e3248c8d672ea8473485d727a")
    fun getTopMovies() : Call<MoviesResponse>

    @GET("/3/movie/upcoming?api_key=6ad27c9e3248c8d672ea8473485d727a")
    fun getUpcomingMovies() : Call<MoviesResponse>

}