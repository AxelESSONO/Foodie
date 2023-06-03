package com.axel.foodie.utility

import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat

fun AppCompatActivity.makeFullScreen() {
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