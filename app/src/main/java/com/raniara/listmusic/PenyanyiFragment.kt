package com.raniara.listmusic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.raniara.listmusic.databinding.FragmentPenyanyiBinding



class PenyanyiFragment : Fragment() {
    lateinit var binding :FragmentPenyanyiBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPenyanyiBinding.inflate(inflater,container,false)
        return binding.root
    }

    var penyanyiAdapter = PenyanyiFragment(listPenyanyi)
    val lm = GridLayoutManager(context,1)


}