package com.example.appfilmes.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appfilmes.R
import com.example.appfilmes.adapter.AdapterProduto
import com.example.appfilmes.models.ModelResult
import com.example.appfilmes.models.Produto
import com.example.appfilmes.repository.FilmeRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val recyclerView_produtos = findViewById<RecyclerView>(R.id.recyclerView_produtos)
        recyclerView_produtos.layoutManager = LinearLayoutManager(this)
        recyclerView_produtos.setHasFixedSize(true)
       //Adapter
        val listaProdutor: MutableList<Produto> = mutableListOf()
        val adapterProduto = AdapterProduto(this,listaProdutor)
        recyclerView_produtos.adapter = adapterProduto




        getdara()

    }

    private fun getdara() {
        val call:Call<ModelResult?>? = FilmeRetrofit()
            .getWeb
            .buscaWeb("2d0383ad0291de2eb08e33ce3fc559aa",
            "pt-BR")

        call?.enqueue(object : Callback<ModelResult?> {
            override fun onResponse(call: Call<ModelResult?>, response: Response<ModelResult?>) {
                if (response.isSuccessful){
                    val teste:ModelResult? = response.body()
                    val result :String = teste.toString()
                    Log.i("TAG","******************** $result")

                }
            }

            override fun onFailure(call: Call<ModelResult?>, t: Throwable) {
                Toast.makeText(applicationContext,"Ocorreu um error ao consultar a API",Toast.LENGTH_LONG).show()
            }
        })
    }
}