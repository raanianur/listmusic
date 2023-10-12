package com.raniara.listmusic

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView


class LaguViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
    private val tvJudulLagu: AppCompatTextView = itemView.findViewById(R.id.tvJudulLagu)
    private val tvNamaAlbum: AppCompatTextView = itemView.findViewById(R.id.tvNamaAlbum)


    fun bind(lagu: LaguData){
        tvJudulLagu.text = lagu.judul
        tvNamaAlbum.text = lagu.Album
    }
}