package com.example.appfilmes.`interface`


import com.example.appfilmes.models.ModelResult
import retrofit2.Call
import retrofit2.http.GET



interface Api_Config {
    @GET("/movie/popilar?api_key=2d0383ad0291de2eb08e33ce3fc559aa")
    fun getModelList(): Call<ModelResult>
}
