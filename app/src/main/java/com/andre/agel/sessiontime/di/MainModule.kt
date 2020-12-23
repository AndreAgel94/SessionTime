package com.andre.agel.sessiontime.di

import com.andre.agel.sessiontime.data.repository.MovieRepository
import com.andre.agel.sessiontime.presentation.viewModel.MoviesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {


    viewModel {
        MoviesViewModel(
            MovieRepository()
        )
    }

}

