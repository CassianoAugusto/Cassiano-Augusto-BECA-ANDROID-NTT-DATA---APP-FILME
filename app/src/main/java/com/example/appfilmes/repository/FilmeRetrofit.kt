package com.example.appfilmes.repository

import com.example.appfilmes.interfaces.Iweb
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FilmeRetrofit {
    private val retrofit by lazy() {
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val getWeb: Iweb by lazy {
        retrofit.create(Iweb::class.java)
    }
}

