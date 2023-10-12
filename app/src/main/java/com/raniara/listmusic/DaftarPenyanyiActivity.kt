package com.raniara.listmusic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DaftarPenyanyiActivity : AppCompatActivity() {

    private val daftarPenyanyi = listOf(
        PenyanyiData("Adele", R.drawable.adele, listOf(
            LaguData("Rolling In The Deep", "21"),
            LaguData("Don't you remember", "21"),

        )),
        PenyanyiData("Alessia Cara", R.drawable.alessia, listOf(
            LaguData("Scars to Your Beautifull", "Know it All"),
            LaguData("Seventeen", "Know it All")
        )),

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar_penyanyi)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewPenyanyi)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PenyanyiAdapter(daftarPenyanyi)

    }

}