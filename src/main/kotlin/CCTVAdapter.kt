package com.skiresort.cctv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CCTVAdapter(private val onClick: (CCTV) -> Unit) : RecyclerView.Adapter<CCTVAdapter.CCTVViewHolder>() {

    private var cctvList: List<CCTV> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CCTVViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1, parent, false)
        return CCTVViewHolder(view)
    }

    override fun onBindViewHolder(holder: CCTVViewHolder, position: Int) {
        val cctv = cctvList[position]
        holder.textView.text = cctv.name
        holder.itemView.setOnClickListener { onClick(cctv) }
    }

    override fun getItemCount(): Int = cctvList.size

    fun submitList(list: List<CCTV>) {
        cctvList = list
        notifyDataSetChanged()
    }

    class CCTVViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(android.R.id.text1)
    }
}
