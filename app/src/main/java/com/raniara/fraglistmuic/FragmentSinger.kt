package com.raniara.fraglistmuic

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentSinger : Fragment() {
    private  var isLinearLayout = true
    private  lateinit var recyclerView: RecyclerView


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


        val toolbar: Toolbar = view.findViewById(R.id.toolbar_nav)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        setHasOptionsMenu(true)

        recyclerView = view.findViewById(R.id.recyclerViewPenyanyi)
        updateLayoutManager()
        recyclerView.adapter = SingerAdapter(daftarPenyanyi) { penyanyiDipilih ->

            val fragment = FragmentSong.newInstance(penyanyiDipilih)

            fragmentManager?.beginTransaction()
                ?.replace(R.id.container, fragment)
                ?.addToBackStack(null)
                ?.commit()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_combined, menu)
        super.onCreateOptionsMenu(menu, inflater)

        val item = menu.findItem(R.id.menu_switch_layout)
        item.icon = if (isLinearLayout) ContextCompat.getDrawable(requireContext(), R.drawable.ic_grid_view) else ContextCompat.getDrawable(requireContext(), R.drawable.ic_view_list)

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.d("DEBUG_LAYOUT", "Is Linear Layout: $isLinearLayout")

        if (item.itemId == R.id.menu_switch_layout) {
            isLinearLayout = !isLinearLayout
            item.icon = if (isLinearLayout) {
                ContextCompat.getDrawable(requireContext(), R.drawable.ic_view_list)
            } else {
                ContextCompat.getDrawable(requireContext(), R.drawable.ic_grid_view)
            }
            updateLayoutManager()
            return true

        }
        return super.onOptionsItemSelected(item)
    }
    private fun updateLayoutManager() {
        recyclerView.layoutManager = null
        if(isLinearLayout){
            recyclerView.layoutManager = LinearLayoutManager(context)
        }else {
            recyclerView.layoutManager = GridLayoutManager(context,2)
        }
        recyclerView.adapter?.notifyDataSetChanged()
        recyclerView.invalidate()


    }

}