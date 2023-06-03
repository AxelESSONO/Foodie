package com.axel.foodie.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import com.axel.foodie.R

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        makeFullScreen()
        setContentView(R.layout.activity_welcome)

    }

    private fun makeFullScreen() {
        // Remove Title
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        // Make Fullscreen
        WindowCompat.getInsetsController(window, window.decorView)
            ?.hide(
                WindowInsetsCompat.Type.statusBars() or
                        WindowInsetsCompat.Type.navigationBars()
            )
        // Hide the toolbar
        supportActionBar?.hide()
    }

}