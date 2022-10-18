package com.gabrielrf.mapsfragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadUrl(url: String){
    Glide.with(this)
        .load(url)
        .into(this)
}

fun ViewGroup.inflate(layout: Int, attach: Boolean): View {
    val view = LayoutInflater.from(this.context).inflate(layout,this, attach)
    return view
}