package com.raniara.listmusic

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView

class PenyanyiViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
    val imgPenyanyiData: ImageView = itemView.findViewById(R.id.imgPenyanyi)
    val tvNamePenyanyiData: AppCompatTextView = itemView.findViewById(R.id.tvNamaPenyanyi)

    fun bind(penyanyiData: PenyanyiData){
        tvNamePenyanyiData.text = penyanyiData.nama
        imgPenyanyiData.setImageResource(penyanyiData.gambar)
    }
}