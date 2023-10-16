package com.raniara.fraglistmuic


import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class SingerAdapter(private val daftarPenyanyi: List<Singer>, private val clickListener: (Singer) -> Unit) :
    RecyclerView.Adapter<SingerAdapter.SingerViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_singer, parent, false)
        return SingerViewHolder(view)
    }
    override fun onBindViewHolder(holder: SingerViewHolder, position: Int) {
        val penyanyiData = daftarPenyanyi[position]
        Log.d("SingerAdapter", "Binding view for position: $position")
        holder.bind(daftarPenyanyi[position], clickListener)
        holder.itemView.setOnClickListener {
            clickListener(penyanyiData)
        }
    }

    override fun getItemCount() = daftarPenyanyi.size

    class SingerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imgPenyanyi: ImageView= view.findViewById(R.id.imgPenyanyi)
        private val tvNamaPenyanyi: TextView = view.findViewById(R.id.tvNamaPenyanyi)

        fun bind(penyanyi: Singer, clickListener: (Singer) -> Unit) {
            tvNamaPenyanyi.text = penyanyi.name
            imgPenyanyi.setImageResource(penyanyi.image)
            itemView.setOnClickListener { clickListener(penyanyi) }
        }
    }
}