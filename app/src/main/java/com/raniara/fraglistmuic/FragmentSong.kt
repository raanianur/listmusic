package com.raniara.fraglistmuic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentSong : Fragment(){
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SongAdapter
    private lateinit var singer: Singer

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_song, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        singer = arguments?.getParcelable("singer")?:return

        recyclerView = view.findViewById(R.id.recyclerViewLagu)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = SongAdapter(singer.listSong)
        recyclerView.adapter = adapter
    }

    companion object{
        fun newInstance(penyanyi: Singer): FragmentSong {
            val fragment = FragmentSong()
            val bundle = Bundle()
            bundle.putParcelable("penyanyi", penyanyi)
            fragment.arguments = bundle
            return fragment
        }
    }

}