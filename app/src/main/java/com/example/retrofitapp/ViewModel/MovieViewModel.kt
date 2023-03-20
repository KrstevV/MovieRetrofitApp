package com.example.retrofitapp.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitapp.Model.MoviesApiService
import com.example.retrofitapp.Model.MoviesData
import com.example.retrofitapp.Model.MoviesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel  : ViewModel() {

       var moviePopularResponse = MutableLiveData<List<MoviesData>>()
       var movieTopRatedResponse = MutableLiveData<List<MoviesData>>()
       var movieUpcomingResponse = MutableLiveData<List<MoviesData>>()


    fun getPopularMovies () {
            MoviesApiService.getPopularMovies().enqueue(object : Callback<MoviesResponse> {
                override fun onResponse(
                    call: Call<MoviesResponse>,
                    response: Response<MoviesResponse>
                ) {
                        if(response.isSuccessful) {
                            moviePopularResponse.value = response.body()!!.listMovies
                        }

                }
                override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                    println("Error retrieving movie data: ${t.message}")
                }
            })
        }

    fun getTopMovies () {

        MoviesApiService.getTopMovies().enqueue(object : Callback<MoviesResponse> {
            override fun onResponse(
                call: Call<MoviesResponse>,
                response: Response<MoviesResponse>
            ) {
                if(response.isSuccessful) {
                    movieTopRatedResponse.value = response.body()!!.listMovies
                }
            }
            override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                println("Error retrieving movie data: ${t.message}")
            }

        })
    }

    fun getUpcomingMovies() {

        MoviesApiService.getUpcomingMovies().enqueue(object : Callback<MoviesResponse> {
            override fun onResponse(
                call: Call<MoviesResponse>,
                response: Response<MoviesResponse>
            ) {
                if(response.isSuccessful) {
                    movieUpcomingResponse.value = response.body()!!.listMovies
                }
            }
            override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                println("Error retrieving movie data: ${t.message}")
            }
        })

    }





}