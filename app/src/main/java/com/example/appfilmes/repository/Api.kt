package com.example.apiteste.repositorio

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class Api {
    companion object{

        fun getRetrofit():Retrofit{
            return Retrofit.Builder()
                .baseUrl("https://my-json-server.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create()).build()
        }
    }
}