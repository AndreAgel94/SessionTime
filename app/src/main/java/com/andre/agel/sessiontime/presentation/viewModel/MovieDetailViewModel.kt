package com.andre.agel.sessiontime.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.andre.agel.sessiontime.data.model.Actor
import com.andre.agel.sessiontime.data.model.Movie
import com.andre.agel.sessiontime.data.repository.MovieRepository

class MovieDetailViewModel(
    private val repository: MovieRepository
) : ViewModel() {

    fun getMovieDetails(id : Int): MutableLiveData<Movie> {
        return repository.getMovieDetails(id)
    }

    fun getMovieActors(id: Int): MutableLiveData<List<Actor>> {
        return repository.getMovieActors(id)
    }

    fun getMoviesRecommendations(id: Int): MutableLiveData<List<Movie>> {
        return repository.getMoviesRecommendations(id)
    }
}