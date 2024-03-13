package com.example.dynamicuichanges

import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.dynamicuichanges.databinding.ActivityFirstScreenBinding

class FirstScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFirstScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFirstScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setFirstScreenImage()

        setButtonListeners()
    }

    private fun setFirstScreenImage(){
        Glide.with(this)
            .load(AppConstants.URL)
            .centerCrop()
            .into(binding.FirstScreenImage)
    }

    private fun setButtonListeners(){
        binding.hide.setOnClickListener {

            binding.FirstScreenImage.animate().apply {
                alpha(0f)
                setDuration(1000)
                setInterpolator(AccelerateDecelerateInterpolator())
            }.start()
        }

        binding.show.setOnClickListener {

            binding.FirstScreenImage.animate().apply {
                alpha(1f)
                setDuration(1000)
                setInterpolator(AccelerateDecelerateInterpolator())
            }.start()
        }
    }
}