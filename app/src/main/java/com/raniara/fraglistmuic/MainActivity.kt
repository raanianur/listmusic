package com.raniara.fraglistmuic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentSinger = FragmentSinger()
        val fragment = supportFragmentManager.findFragmentByTag(FragmentSinger::class.java.simpleName)

        if (fragment == null){
            supportFragmentManager.beginTransaction()
                .add(R.id.container, fragmentSinger, FragmentSinger::class.java.simpleName)
                .commit()
        }



    }
}