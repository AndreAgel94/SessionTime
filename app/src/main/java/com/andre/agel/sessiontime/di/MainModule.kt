package com.andre.agel.sessiontime.di

import androidx.room.Room
import com.andre.agel.sessiontime.data.database.AppDatabase
import com.andre.agel.sessiontime.data.repository.MovieRepository
import com.andre.agel.sessiontime.presentation.viewModel.MovieDetailViewModel
import com.andre.agel.sessiontime.presentation.viewModel.MoviesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {


    viewModel {
        MoviesViewModel(
            MovieRepository(get(), get())
        )
    }
    viewModel {
        MovieDetailViewModel(
            MovieRepository(get(), get())
        )
    }

    factory { MovieRepository(get(), get()) }

    single { Room.databaseBuilder(
        get(),
        AppDatabase::class.java,
        "app_database"
    ).build() }
    single { get<AppDatabase>().movieDao() }
    single { get<AppDatabase>().actorDao() }

}

