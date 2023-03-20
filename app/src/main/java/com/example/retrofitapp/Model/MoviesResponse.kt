package com.example.retrofitapp.Model

import com.google.gson.annotations.SerializedName

data class MoviesResponse(

        @SerializedName("results")
        var listMovies : List<MoviesData>

        )
