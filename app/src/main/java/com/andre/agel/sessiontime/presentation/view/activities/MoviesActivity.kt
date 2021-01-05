package com.andre.agel.sessiontime.presentation.view.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andre.agel.sessiontime.R
import com.andre.agel.sessiontime.presentation.view.adapter.MovieAdapter
import com.andre.agel.sessiontime.presentation.view.fragments.FavoritesFragment
import com.andre.agel.sessiontime.presentation.view.fragments.MovieFragment
import com.andre.agel.sessiontime.presentation.viewModel.MoviesViewModel
import com.bumptech.glide.Glide
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.activity_main.*
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
        val bottomNavBar : BottomNavigationView =  findViewById(R.id.bottomNavBar)

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
                    }
                    true
                }
                R.id.settingsBottom ->{

                    true
                }
                else -> false
            }
        }
    }
}