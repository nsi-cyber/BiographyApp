package com.nsicyber.biographyapp.adapter

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.nsicyber.biographyapp.R
import com.nsicyber.biographyapp.activities.ImageReviewActivity


class GalleryAdapter(private val myList: List<String>,var context: Context) : RecyclerView.Adapter<PhotoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder, parent, false)
        return PhotoViewHolder(view,myList,context)
    }


    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val currentItem = myList[position]
        Glide.with(context)
            .load(currentItem)
            .diskCacheStrategy(DiskCacheStrategy.DATA)
            .into(holder.image)
    }


    override fun getItemCount() = myList.size
}

class PhotoViewHolder(itemView: View, list: List<String>, context: Context) : RecyclerView.ViewHolder(itemView) {
    val image: ImageView = itemView.findViewById(R.id.imageView)
}
