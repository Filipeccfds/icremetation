 package com.filipe.appicremetion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.filipe.appicremetion.databinding.ActivityMainBinding
import kotlin.properties.Delegates

 class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btn.setOnClickListener {
            binding.text1.text = binding.nomeEditavel.text
            val intent= Intent(this,ResultActivity::class.java)
            intent.putExtra(ResultActivity.ARG_NAME,binding.nomeEditavel.text.toString())
            startActivity(intent)
        }
    }

     override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
         super.onSaveInstanceState(outState, outPersistentState)
             //salvando o nome antes de destruir a activity
         outState.putString(ResultActivity.ARG_NAME,binding.nomeEditavel.text.toString())
     }

     override fun onRestoreInstanceState(savedInstanceState: Bundle) {
         super.onRestoreInstanceState(savedInstanceState)
         //restaurando o valor
         val savedName = savedInstanceState?.getString(ResultActivity.ARG_NAME)
         savedName.let{
             binding.text1.text = it
         }
     }

}