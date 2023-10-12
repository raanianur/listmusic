package com.raniara.listmusic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DaftarLaguActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar_lagu)

        val penyanyi = intent.getParcelableExtra<PenyanyiData>("PENYANYI_SELECTED")
        val daftarLagu = penyanyi?.daftarLagu


        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewLagu)
        recyclerView.layoutManager = LinearLayoutManager(this)
        if (daftarLagu != null){
            recyclerView.adapter = LaguAdapter(daftarLagu)
        }

    }
}