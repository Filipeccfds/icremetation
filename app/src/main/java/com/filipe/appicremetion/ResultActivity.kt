package com.filipe.appicremetion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.filipe.appicremetion.databinding.ActivityMainBinding
import com.filipe.appicremetion.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val get = intent.extras?.getString("ARG_NAME","nenhume valor informado")
        binding.titleResult.text = get


    }

    companion object{
        const val ARG_NAME = "ARG_NAME"

    }
}