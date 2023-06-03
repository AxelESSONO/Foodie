package com.axel.foodie.view.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.axel.foodie.R
import com.axel.foodie.databinding.ActivityWelcomeBinding
import com.axel.foodie.model.data.SampleData
import com.axel.foodie.utility.makeFullScreen
import com.axel.foodie.view.adapter.WelcomeSlideAdapter

class WelcomeActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        makeFullScreen()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_welcome)

        binding.welcomeSlide.apply {
            adapter = WelcomeSlideAdapter(SampleData.slideItems)
        }
        binding.welcomeSlide.currentItem = 0
        initDot()
        setCurrentIndicator(0)
        binding.welcomeSlide.registerOnPageChangeCallback(object :
        ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
        })
        binding.setDeliveryLocationBtn.setOnClickListener(this)
    }

    private fun initDot() {

        val indicators =
            binding.welcomeSlide.adapter?.itemCount?.let { arrayOfNulls<ImageView>(it) }
        val dotLayoutParams: LinearLayout.LayoutParams = LinearLayout.LayoutParams(40, 40)
        dotLayoutParams.setMargins(25, 0, 0, 0)
        if (indicators != null) {
            for (position in indicators.indices) {
                indicators[position] = ImageView(applicationContext)
                indicators[position]?.let {
                    it.apply {
                        setImageDrawable(
                            ContextCompat.getDrawable(
                                applicationContext,
                                R.drawable.circle_grey_unselected
                            )
                        )
                        layoutParams = dotLayoutParams
                    }
                    binding.dotLinear.addView(it)
                }
            }
        }
    }

    private fun setCurrentIndicator(position : Int){
        val childCount = binding.dotLinear.childCount
        for (dotCursor in 0 until childCount){
            val imageView = binding.dotLinear.getChildAt(dotCursor) as ImageView
            if (dotCursor == position){
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.circle_yellow_selected
                    )
                )
            }else{
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.circle_grey_unselected
                    )
                )
            }
        }
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            binding.setDeliveryLocationBtn.id -> startActivity(
                Intent(this@WelcomeActivity, LocationMapActivity::class.java)
            )
        }
    }
}































