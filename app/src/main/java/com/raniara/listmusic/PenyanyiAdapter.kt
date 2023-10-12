package com.raniara.listmusic

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class PenyanyiAdapter(
    private val daftarPenyanyi:List<PenyanyiData>
): RecyclerView.Adapter<PenyanyiViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PenyanyiViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_penyanyi,parent, false)
        return PenyanyiViewHolder(view)
    }

    override fun onBindViewHolder(holder: PenyanyiViewHolder, position: Int) {
        holder.bind(daftarPenyanyi[position])
        val item = daftarPenyanyi[position]
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DaftarLaguActivity::class.java)
            intent.putExtra("PENYANYI_SELECTED",item)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = daftarPenyanyi.size


}
