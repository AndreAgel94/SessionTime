package com.andre.agel.sessiontime.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.andre.agel.sessiontime.R
import com.andre.agel.sessiontime.data.repository.MovieRepository

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_details)
    }

}