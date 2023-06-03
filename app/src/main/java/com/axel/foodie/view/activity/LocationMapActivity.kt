package com.axel.foodie.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.axel.foodie.R
import com.axel.foodie.utility.makeFullScreen

class LocationMapActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        makeFullScreen()
        setContentView(R.layout.activity_location_map)
    }
}