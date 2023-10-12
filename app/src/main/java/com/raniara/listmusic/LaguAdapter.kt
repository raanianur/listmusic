package com.raniara.listmusic

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class LaguAdapter (private val daftarlagu: List<LaguData>) : RecyclerView.Adapter<LaguViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaguViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lagu, parent, false)
        return LaguViewHolder(view)
    }

    override fun onBindViewHolder(holder: LaguViewHolder, position: Int) {
        holder.bind(daftarlagu[position])
        val item = daftarlagu[position]
        holder.itemView.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.google.com/search?q="+item.judul)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = daftarlagu.size
}