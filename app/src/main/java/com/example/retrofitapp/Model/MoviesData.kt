package com.example.retrofitapp.Model

import com.google.gson.annotations.SerializedName

data class MoviesData (

    @SerializedName("id")
    var id : Int?,

    @SerializedName("title")
    var title : String?,

    @SerializedName("release_date")
    var date : String?,

    @SerializedName("poster_path")
    var img : String?



        )
