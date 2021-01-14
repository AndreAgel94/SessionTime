package com.andre.agel.sessiontime.di

import androidx.room.Room
import com.andre.agel.sessiontime.data.database.AppDatabase
import com.andre.agel.sessiontime.data.network.TmdbServices
import com.andre.agel.sessiontime.data.repository.MovieRepository
import com.andre.agel.sessiontime.presentation.viewModel.FavoritesViewModel
import com.andre.agel.sessiontime.presentation.viewModel.MovieDetailViewModel
import com.andre.agel.sessiontime.presentation.viewModel.MoviesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val viewModelModule = module {


    viewModel {
        MoviesViewModel(
            MovieRepository(get(), get(), get())
        )
    }
    viewModel {
        MovieDetailViewModel(
            MovieRepository(get(), get(), get())
        )
    }

    viewModel {
        FavoritesViewModel(
            MovieRepository(get(), get(), get())
        )
    }

    factory { MovieRepository(get(), get(), get()) }

    single {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            "app_database"
        ).build()
    }

    single {
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TmdbServices::class.java)
    }

    single { get<AppDatabase>().movieDao() }
    single { get<AppDatabase>().actorDao() }


}

