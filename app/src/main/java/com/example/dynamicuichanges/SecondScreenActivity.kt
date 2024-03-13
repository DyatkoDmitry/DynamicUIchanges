package com.example.dynamicuichanges

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.dynamicuichanges.databinding.ActivitySecondScreenBinding

class SecondScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondScreenBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setScreensImages()

        setButtonsListeners()
    }

    private fun setScreensImages(){

        Glide.with(this)
            .load(AppConstants.URL)
            .centerCrop()
            .into(binding.SecondScreenImage1)


        Glide.with(this)
            .load(AppConstants.URL)
            .centerCrop()
            .into(binding.SecondScreenImage2)
    }

    private fun setButtonsListeners(){

        binding.add.setOnClickListener {
            binding.SecondScreenImage2.visibility = View.VISIBLE
            binding.spaceBehindImage2.visibility = View.VISIBLE
        }

        binding.remove.setOnClickListener {
            binding.SecondScreenImage2.visibility = View.GONE
            binding.spaceBehindImage2.visibility = View.GONE
        }
    }
}