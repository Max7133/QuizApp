package com.example.quizapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.VideoView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        playVideo()

        // to go to the recyclerview page
        val button: Button = findViewById(R.id.recyclerView_btn)
        button.setOnClickListener {
            val intent = Intent(this,RecyclerViewActivity::class.java)
            startActivity(intent)
            finish()
        }

    }


    // for opening the activity
    // I use intent,navigating "this" which is onCreate activity using the start activity method
    // view: View passing the reference to the button to make it visible there
    fun openActivity(view: View) {
        startActivity(Intent(this, QuizActivity::class.java))
    }

    //for playing the video
  fun playVideo() {
        val video = findViewById<VideoView>(R.id.background_video)
        val videoUri = Uri.parse("android.resource://" + packageName + "/" + R.raw.super_sunset)
        video.setVideoURI(videoUri)
        video.start()
    }
}
