package com.example.rushandroid.ui

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.rushandroid.R
import com.example.rushandroid.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var navController: NavController

    lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )


        navController = findNavController(R.id.nav_host_fragment_home)

        navController.setGraph(R.navigation.nav_graph)

        appBarConfiguration =AppBarConfiguration(setOf(R.id.WelcomePage))

        setupActionBarWithNavController(navController,appBarConfiguration)
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }


    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.nav_host_fragment_home).navigateUp(appBarConfiguration)
    }

}