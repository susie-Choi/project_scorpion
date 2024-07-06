package com.example.project_scorpion

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import com.google.android.exoplayer2.ui.StyledPlayerView // 변경된 부분
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource

class MainActivity : AppCompatActivity() {
    private var exoPlayer: ExoPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val playerView = findViewById<StyledPlayerView>(R.id.playerView) // 변경된 부분

        // ExoPlayer 초기화
        exoPlayer = ExoPlayer.Builder(this).build()
        playerView.player = exoPlayer

        // HLS 스트리밍 URL 설정
        val videoUrl = "https://streaming.phoenixhnr.co.kr/hls/ht_01.m3u8"
        val dataSourceFactory = DefaultHttpDataSource.Factory()
        val mediaSource = HlsMediaSource.Factory(dataSourceFactory)
            .createMediaSource(MediaItem.fromUri(videoUrl))

        // 동영상 재생
        exoPlayer?.setMediaSource(mediaSource)
        exoPlayer?.prepare()
        exoPlayer?.playWhenReady = true
    }

    override fun onDestroy() {
        super.onDestroy()
        exoPlayer?.release()
        exoPlayer = null
    }
}