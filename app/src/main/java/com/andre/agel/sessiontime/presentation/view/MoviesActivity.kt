package com.andre.agel.sessiontime.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.andre.agel.sessiontime.R
import com.andre.agel.sessiontime.presentation.viewModel.MoviesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MoviesActivity : AppCompatActivity() {
    val viewModel : MoviesViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


}