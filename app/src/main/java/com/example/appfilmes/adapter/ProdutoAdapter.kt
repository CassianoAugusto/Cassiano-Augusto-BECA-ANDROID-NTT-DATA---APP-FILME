package com.example.appfilmes.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.appfilmes.R
import com.example.appfilmes.models.Produto
import com.example.appfilmes.view.SegundaTela
import com.squareup.picasso.Picasso

class ProdutoAdapter(private val context: Context, private val produtos: List<Produto>) :
    RecyclerView.Adapter<ProdutoAdapter.ProdutoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoViewHolder {
        val itemLista = LayoutInflater.from(context).inflate(R.layout.filmes_item, parent, false)
        val holder = ProdutoViewHolder(itemLista)
        return holder
    }

    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {
        val item = produtos.get(position)

        Picasso.get().load("https://image.tmdb.org/t/p/w500/" + item.poster_path).into(holder.foto)
        holder.title.text = produtos[position].title
        holder.overview.text = produtos[position].overview
        holder.voto.text = produtos[position].vote_average.toString()
        holder.button.setOnClickListener {

            val intent = SegundaTela.getIntent(this.context, produtos[position])
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = produtos.size

    inner class ProdutoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val foto = itemView.findViewById<ImageView>(R.id.foto)
        val title = itemView.findViewById<TextView>(R.id.nomefilme)
        val overview = itemView.findViewById<TextView>(R.id.descricao)
        val voto = itemView.findViewById<TextView>(R.id.voto)
        val button = itemView.findViewById<ConstraintLayout>(R.id.itemm)
    }

}





