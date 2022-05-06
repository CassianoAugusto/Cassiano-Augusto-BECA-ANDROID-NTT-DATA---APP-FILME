package com.example.appfilmes.interfaces

import com.example.appfilmes.models.ModelResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Iweb {
    @GET("3/trending/movie/week?")
    fun buscaWeb(@Query ("api_key")apikey:String,
    @Query("language")linguagem:String): Call<ModelResult?>?

}


//https://api.themoviedb.org/3/trending/movie/week?api_key=2d0383ad0291de2eb08e33ce3fc559aa