package com.smb5.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.smb5.R
import java.lang.reflect.Field
import android.media.MediaPlayer
import android.widget.Button


class Sound : AppCompatActivity() {
    lateinit var albumImageView: ImageView
    lateinit var mediaPlayer: MediaPlayer
    val tracks: Array<Field> = R.raw::class.java.fields
    var currentSongId = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sound)

        albumImageView = findViewById(R.id.albumImageView)
        albumImageView.setImageResource(getIdentifier("drawable", tracks[0].name))

        mediaPlayer = MediaPlayer.create(this, getIdentifier("raw", tracks[0].name))
    }

    fun togglePlay(view: android.view.View) {
        if (mediaPlayer.isPlaying) {
            findViewById<Button>(R.id.playButton).setBackgroundResource(R.drawable.play)
            mediaPlayer.pause()
        } else {
            findViewById<Button>(R.id.playButton).setBackgroundResource(R.drawable.pause)
            mediaPlayer.start()
        }
    }

    fun stop(view: android.view.View) {
        mediaPlayer.pause()
        mediaPlayer.seekTo(0)
        findViewById<Button>(R.id.playButton).setBackgroundResource(R.drawable.play)
    }

    fun next(view: android.view.View) {
        mediaPlayer.stop()
        mediaPlayer.release()
        currentSongId++
        if (currentSongId == tracks.size) {
            currentSongId = 0
        }
        mediaPlayer = MediaPlayer.create(this, getIdentifier("raw", tracks.get(currentSongId).name))
        albumImageView.setImageResource(getIdentifier("drawable", tracks.get(currentSongId).name))
        findViewById<Button>(R.id.playButton).setBackgroundResource(R.drawable.play)

    }

    fun getIdentifier(defType: String, name: String): Int {
        return resources.getIdentifier(name, defType, packageName)
    }
}