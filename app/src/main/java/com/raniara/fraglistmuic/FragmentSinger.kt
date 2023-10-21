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
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentSinger : Fragment() {
    private  var isLinearLayout = true
    private lateinit var viewModel: PenyanyiViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var singerAdapter: SingerAdapter



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_singer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(PenyanyiViewModel::class.java)

        val toolbar: Toolbar = view.findViewById(R.id.toolbar_nav)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        setHasOptionsMenu(true)

        recyclerView = view.findViewById(R.id.recyclerViewPenyanyi)
        updateLayoutManager()
        singerAdapter = SingerAdapter() { penyanyiDipilih ->

            val fragment = FragmentSong.newInstance(penyanyiDipilih)

            fragmentManager?.beginTransaction()
                ?.replace(R.id.container, fragment)
                ?.addToBackStack(null)
                ?.commit()
        }
        recyclerView.adapter = singerAdapter
        viewModel.daftarPenyanyi.observe(viewLifecycleOwner){
            singerAdapter.submitList(it)
        }
        viewModel.provideDaftarPenyanyi()
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