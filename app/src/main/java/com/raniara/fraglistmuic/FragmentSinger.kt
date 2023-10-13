package com.raniara.fraglistmuic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentSinger : Fragment() {
    private val daftarPenyanyi: List<Singer> = listOf(
        Singer("Sia", R.drawable.sia, listOf(
            Song("Snowman", "Everyday Is Christmas"),
            Song("Chandelier", "1000 Forms of Fear"),
            Song("Genius ft Diplo, Labrinth", "LSD"),
            Song("Cheap Thrills ft Sean Paul", "This Is Acting"),
            Song("No New Friends ft Diplo, Labrinth", "LSD")
    )),
        Singer("Taylor Swift", R.drawable.taylor, listOf(
            Song("Shake it off", "1989"),
            Song("Style", "1989"),
            Song("Blank Space", "1989"),
            Song("Love Story", "Fearless"),
            Song("Red", "Red"),
            Song("22", "Red"),
            Song("Look What You Made Me Do", "Reputation"),
            Song("Back To December", "Speak Now")
        )),
        Singer("Raisa", R.drawable.raaisaa, listOf(
            Song("Usai di Sini", "Handmade"),
            Song("Kali Kedua", "Handmade"),
            Song("Mantan Terindah", "Raisa"),
            Song("Could it be", "Raisa"),
            Song("Terjebak Nostalgia", "Raisa"),
            Song("Teka-teki", "Raisa")
        )),
        Singer("Tulus", R.drawable.tulus, listOf(
            Song("Gajah", "Gajah"),
            Song("1000 Tahun Lamanya", "Single OST Tenggelamnya Kapal Van Der Wijck"),
            Song("Pamit", "Monokrom"),
            Song("Manusia Kuat", "Monokrom"),
            Song("Hati-Hati di Jalan", "Monokrom"),
            Song("Sepatu", "Sepatu"),
            Song("Baru", "Gajah")
        ))
    )
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_singer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerViewPenyanyi)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = SingerAdapter(daftarPenyanyi)
    }
}