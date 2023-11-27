package com.example.tictactoex0

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    private lateinit var button: Button

    private lateinit var volumeOn:ImageView
    private lateinit var volumeOff:ImageView

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mediaPlayer = MediaPlayer.create(this,R.raw.music1)
        mediaPlayer.isLooping = true
        mediaPlayer.start()

        init()
        startActivity()
        volumeActivity()
    }
    private fun init(){
        button = findViewById(R.id.button)
        volumeOn = findViewById(R.id.volumeOn)
        volumeOff = findViewById(R.id.volumeOff)
    }

    private fun startActivity(){
        button.setOnClickListener {
            val intent = Intent(this,PlayerActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun volumeActivity(){
        volumeOn.setOnClickListener {
            if (volumeOn.alpha == 1F){
                mediaPlayer.pause()
                volumeOn.alpha= 0F
                volumeOff.alpha= 1F
            }
            else {
                mediaPlayer.start()
                volumeOff.alpha = 0F
                volumeOn.alpha = 1F

            }
        }
    }

}