package com.skiresort.cctv

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var cctvAdapter: CCTVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        cctvAdapter = CCTVAdapter { cctv ->
            val intent = Intent(this, CCTVPlayerActivity::class.java)
            intent.putExtra("cctv_url", cctv.url)
            startActivity(intent)
        }
        recyclerView.adapter = cctvAdapter

        val cctvList = loadCCTVListFromAssets()
        cctvAdapter.submitList(cctvList)
    }

    private fun loadCCTVListFromAssets(): List<CCTV> {
        val assetManager = assets
        val inputStream = assetManager.open("cctv_list.json")
        val reader = InputStreamReader(inputStream)
        return Gson().fromJson(reader, object : TypeToken<List<CCTV>>() {}.type)
    }
}
