package com.axel.foodie.utility

import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("android:imageResource")
fun setBackground(view: ImageView, resource : Int) {
    view.setImageResource(resource)
}