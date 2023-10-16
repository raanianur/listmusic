package com.raniara.fraglistmuic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        NavigationUI.setupActionBarWithNavController(this, navController)


        val fragmentSinger = FragmentSinger()
        val fragment = supportFragmentManager.findFragmentByTag(FragmentSinger::class.java.simpleName)

        if (fragment == null){
            supportFragmentManager.beginTransaction()
                .add(R.id.container, fragmentSinger, FragmentSinger::class.java.simpleName)
                .commit()
        }

    }
    override fun onSupportNavigateUp() : Boolean{
        return NavigationUI.navigateUp(Navigation.findNavController(this, R.id.nav_host_fragment), null)
    }
}


//        val toolbar = findViewById<Toolbar>(R.id.toolbar_nav)
//        setSupportActionBar(toolbar)
//
//        NavigationUI.setupWithNavController(toolbar, navController)
