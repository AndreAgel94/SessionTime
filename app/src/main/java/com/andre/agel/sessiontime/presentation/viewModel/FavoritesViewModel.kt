package com.andre.agel.sessiontime.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.andre.agel.sessiontime.data.model.Movie
import com.andre.agel.sessiontime.data.repository.MovieRepository

class FavoritesViewModel(
    private val repository: MovieRepository
) : ViewModel(){

    fun getAllMovies(): MutableLiveData<List<Movie>> {
        return repository.getAllMoviesDB()
    }

}