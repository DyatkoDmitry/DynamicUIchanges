package com.example.dynamicuichanges

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.example.dynamicuichanges.databinding.ActivityThirdScreenBinding
import kotlin.math.roundToInt

class ThirdScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdScreenBinding

    private var currentAlpha = 1f
        get(){
            return roundCurrentAlpha(field)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityThirdScreenBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setScreenImage()

        binding.addAlpha.setOnClickListener {
            increaseAlpha()
        }

        binding.removeAlpha.setOnClickListener {
            decreaseAlpha()
        }
    }

    private fun setScreenImage(){
        Glide.with(this)
            .load(AppConstants.URL)
            .centerCrop()
            .into(binding.ScreenImage)
    }

    private fun roundCurrentAlpha(currentAlpha: Float) = (currentAlpha*100).roundToInt() / 100f

    private fun increaseAlpha(){

        if(currentAlpha >= 1f) return

        ObjectAnimator.ofFloat(binding.ScreenImage,View.ALPHA, currentAlpha, currentAlpha + AppConstants.STEP_ALPHA).start()
        currentAlpha += 0.1f
    }

    private fun decreaseAlpha(){
        if(currentAlpha <= 0f) return

        ObjectAnimator.ofFloat(binding.ScreenImage,View.ALPHA, currentAlpha, currentAlpha - AppConstants.STEP_ALPHA).start()
        currentAlpha -= 0.1f
    }
}