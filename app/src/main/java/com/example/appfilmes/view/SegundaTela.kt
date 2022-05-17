package com.example.appfilmes.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.appfilmes.R
import com.example.appfilmes.models.Produto
import com.squareup.picasso.Picasso

class SegundaTela : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda_tela)

        val foto = findViewById<ImageView>(R.id.foto)
        val title = findViewById<TextView>(R.id.nomefilme)
        val overview = findViewById<TextView>(R.id.descricao)

        Picasso.get().load("https://image.tmdb.org/t/p/w500/" + obtercapa()).into(foto)
        title.text = obterTitulo()
        overview.text = obterDescricao()
    }

    fun obterTitulo() = intent.getStringExtra("titulo")
    fun obterDescricao() = intent.getStringExtra("descricao")
    fun obtercapa() = intent.getStringExtra("capa")

    companion object {
        fun getIntent(
            context: Context,
            produto: Produto
        ): Intent {
            val intent = Intent(context, SegundaTela::class.java)
            intent.putExtra("filmeid", produto.id)
            intent.putExtra("capa", produto.backdrop_path)
            intent.putExtra("titulo", produto.title)
            intent.putExtra("descricao", produto.overview)
            return intent
        }
    }
}

