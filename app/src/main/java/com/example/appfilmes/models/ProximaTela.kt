package com.example.appfilmes.models

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.appfilmes.databinding.AcivityProximaTelaBinding

class ProximaTela : AppCompatActivity() {

    private val binding by lazy {
        AcivityProximaTelaBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}