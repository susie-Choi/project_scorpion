package com.skiresort.cctv

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.PlayerView

class CCTVPlayerActivity : AppCompatActivity() {

    private lateinit var playerView: PlayerView
    private lateinit var player: ExoPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cctv_player)

        playerView = findViewById(R.id.playerView)
        player = ExoPlayer.Builder(this).build()
        playerView.player = player

        val url = intent.getStringExtra("cctv_url")
        if (url != null) {
            val mediaItem = MediaItem.fromUri(Uri.parse(url))
            player.setMediaItem(mediaItem)
            player.prepare()
            player.play()
        }
    }

    override fun onStop() {
        super.onStop()
        player.release()
    }
}
