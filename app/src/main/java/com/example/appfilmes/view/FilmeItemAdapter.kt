package com.example.appfilmes.view

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.appfilmes.databinding.ActivityMainBinding
import com.example.appfilmes.databinding.FilmeListItemBinding
import com.example.appfilmes.models.ModelResult

class FilmeItemAdapter: ListAdapter<FilmeItemAdapter.FilmeItemViewHolder>() {


    class FilmeItemViewHolder(private val binding: FilmeListItemBinding):
        RecyclerView.ViewHolder(binding.root){

    }
companion object{
    private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<>(){

    }
 }
}



