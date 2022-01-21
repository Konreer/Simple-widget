package com.smb5.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.smb5.R

class Image : AppCompatActivity() {
    lateinit var albumImageView: ImageView
    lateinit var imagesIDs: ArrayList<Int>
    var currentImageId = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)
        albumImageView = findViewById(R.id.imageView)

        imagesIDs = arrayListOf(R.drawable.cat1, R.drawable.cat2, R.drawable.cat3, R.drawable.cat4)

        albumImageView.setImageResource(imagesIDs.get(currentImageId))
    }

    fun nextImage(view: android.view.View) {
        currentImageId++
        if (currentImageId== imagesIDs.size) {
            currentImageId = 0
        }
        albumImageView.setImageResource(imagesIDs.get(currentImageId))
    }

    fun previousImage(view: android.view.View) {
        currentImageId--
        if (currentImageId == -1) {
            currentImageId = imagesIDs.size-1
        }
        albumImageView.setImageResource(imagesIDs.get(currentImageId))
    }
}