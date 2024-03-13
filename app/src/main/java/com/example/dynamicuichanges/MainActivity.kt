package com.example.dynamicuichanges

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dynamicuichanges.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setButtonsListeners()
    }

    private fun setButtonsListeners(){
        binding.firstScreen.setOnClickListener {
            startActivity(Intent(this, FirstScreenActivity::class.java))
        }

        binding.secondScreen.setOnClickListener {
            startActivity(Intent(this, SecondScreenActivity::class.java))
        }

        binding.thirdScreen.setOnClickListener {
            startActivity(Intent(this, ThirdScreenActivity::class.java))
        }
    }
}