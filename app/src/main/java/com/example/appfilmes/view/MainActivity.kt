package com.example.appfilmes.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appfilmes.R
import com.example.appfilmes.adapter.ProdutoAdapter
import com.example.appfilmes.models.ModelResult
import com.example.appfilmes.models.Produto
import com.example.appfilmes.repository.FilmeRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    var listFilmes:ModelResult?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getdara()

    }

    private fun iniciandoRecyclerView(list : List<Produto>) {

        val recyclerView_produtos = findViewById<RecyclerView>(R.id.recyclerView_produtos)
        recyclerView_produtos.layoutManager = LinearLayoutManager(this)
        recyclerView_produtos.setHasFixedSize(true)
        //Adapter
        val produtoAdapter = list?.let { ProdutoAdapter(this, it) }
        Log.i("TAG" ,"&&&&&&&&&&&&&&&&&&& $list")
        recyclerView_produtos.adapter = produtoAdapter

    }

    private fun getdara() {
        val call:Call<ModelResult?>? = FilmeRetrofit()
            .getWeb
            .buscaWeb("2d0383ad0291de2eb08e33ce3fc559aa",
            "pt-BR")

        call?.enqueue(object : Callback<ModelResult?> {
            override fun onResponse(call: Call<ModelResult?>, response: Response<ModelResult?>) {
                if (response.isSuccessful){
                    val result :ModelResult?= response.body()
                    var list = result?.results
                    Log.i("TAG","******************** $list")
                    list?.let { iniciandoRecyclerView(it) }

                }
            }

            override fun onFailure(call: Call<ModelResult?>, t: Throwable) {
                Toast.makeText(applicationContext,"Ocorreu um error ao consultar a API",Toast.LENGTH_LONG).show()
            }

        })
    }


}