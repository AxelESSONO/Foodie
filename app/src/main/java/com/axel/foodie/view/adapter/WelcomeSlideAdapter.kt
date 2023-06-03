package com.axel.foodie.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.axel.foodie.R
import com.axel.foodie.databinding.SlideItemBinding
import com.axel.foodie.model.Slide

class WelcomeSlideAdapter(private val slideItems: List<Slide>) :
    RecyclerView.Adapter<WelcomeSlideAdapter.WelcomeSlideHolder>() {

    class WelcomeSlideHolder(private val binding: SlideItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(slide: Slide) {
            binding.slide = slide
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WelcomeSlideHolder =
        WelcomeSlideHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.slide_item,
                parent,
                false
            )
        )


    override fun getItemCount(): Int = slideItems.size

    override fun onBindViewHolder(holder: WelcomeSlideHolder, position: Int) {
        holder.bind(slideItems[position])
    }
}