package com.example.lesson7

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadWithGlide(url: String) {
    Glide.with(this).load(url).into(this)
}