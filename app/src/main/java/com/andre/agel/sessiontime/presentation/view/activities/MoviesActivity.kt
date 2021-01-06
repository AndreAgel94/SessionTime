package com.andre.agel.sessiontime.presentation.view.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.andre.agel.sessiontime.R
import com.andre.agel.sessiontime.presentation.view.fragments.FavoritesFragment
import com.andre.agel.sessiontime.presentation.view.fragments.MovieFragment
import com.andre.agel.sessiontime.presentation.viewModel.MoviesViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel

class MoviesActivity : AppCompatActivity() {

    val viewModel : MoviesViewModel by viewModel()
    val movieFragment  = MovieFragment()
    val favoritesFragment  = FavoritesFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container , movieFragment)
            commit()
        }
        val bottomNavBar : BottomNavigationView =  findViewById(R.id.bottom_navigation)

        bottomNavBar.setOnNavigationItemSelectedListener { item->
            when(item.itemId){
                R.id.homeBottom -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragment_container , movieFragment)
                        commit()
                    }
                    true
                }
                R.id.searchBottom ->{
                    true
                }
                R.id.favoritesBottom ->{
                    Log.i("favoritos", "favoritos")
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragment_container , favoritesFragment )
                        commit()
                    }
                    true
                }
                else -> false
            }
        }
    }
}