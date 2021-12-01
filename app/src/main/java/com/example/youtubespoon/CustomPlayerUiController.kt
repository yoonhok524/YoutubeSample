package com.example.youtubespoon

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.Button
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.YouTubePlayerTracker
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

class CustomPlayerUiController(
    private val context: Context,
    private val customPlayerUi: View,
    private val youtubePlayer: YouTubePlayer,
    private val youtubePlayerView: YouTubePlayerView
) : AbstractYouTubePlayerListener() {

    var playerTracker: YouTubePlayerTracker = YouTubePlayerTracker()

    init {
        youtubePlayer.addListener(playerTracker)
        initView()
    }

    private fun initView() {

        val btn1 = customPlayerUi.findViewById<Button>(R.id.button1)
        val btn2 = customPlayerUi.findViewById<Button>(R.id.button2)
        val view = customPlayerUi.findViewById<View>(R.id.view)

        view.setOnClickListener {

            Log.d("controller", "btn1 clicked")
            if (playerTracker.state == PlayerConstants.PlayerState.PLAYING) youtubePlayer.pause()
            else youtubePlayer.play()
        }

        btn1.setOnClickListener {
            youtubePlayer.mute()
            Log.d("controller", "muted")
        }

        btn2.setOnClickListener {
            youtubePlayer.unMute()
            Log.d("controller", "btn2 clicked, unMuted")
        }
    }

}