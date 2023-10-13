package com.raniara.fraglistmuic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SingerAdapter(private val listSong: List<Song>) : RecyclerView.Adapter<SongAdapter.SongViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongAdapter.SongViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_song, parent, false)
        return LaguViewHolder(view)

    }

    override fun onBindViewHolder(holder: SongAdapter.SongViewHolder, position: Int) {
        holder.bind(listSong[position])
    }

    override fun getItemCount(): Int = listSong.size

    class LaguViewHolder(view : View) : RecyclerView.ViewHolder(view){
        private val tvTitleSong: TextView
    }
}