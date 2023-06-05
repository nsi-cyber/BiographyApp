package com.nsicyber.biographyapp.activities

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.bumptech.glide.Glide
import com.nsicyber.biographyapp.R
import com.nsicyber.biographyapp.databinding.ActivityImageReviewBinding
import com.nsicyber.biographyapp.databinding.ActivityMainBinding

class ImageReviewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImageReviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityImageReviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras

        val myData = bundle?.getString("url")

        Glide.with(this).load(myData).into(binding.imageView)
    }



}