package com.raniara.fraglistmuic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class SongAdapter(private val daftarLagu: List<Song>) : RecyclerView.Adapter<SongAdapter.SongViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_song, parent, false)
        return SongViewHolder(view)
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        holder.bind(daftarLagu[position])
    }

    override fun getItemCount(): Int = daftarLagu.size

    class SongViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvJudulLagu: TextView = view.findViewById(R.id.tvTitleSong)
        private val tvAlbumLagu: TextView = view.findViewById(R.id.tvAlbumSong)

        fun bind(lagu: Song) {
            tvJudulLagu.text = lagu.title
            tvAlbumLagu.text = lagu.album
        }
    }

}