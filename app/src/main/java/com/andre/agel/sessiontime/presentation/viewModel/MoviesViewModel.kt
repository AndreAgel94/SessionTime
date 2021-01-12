package com.andre.agel.sessiontime.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.andre.agel.sessiontime.data.model.Movie
import com.andre.agel.sessiontime.data.repository.MovieRepository

class MoviesViewModel(
    private val repository: MovieRepository
) : ViewModel() {

    fun getTopRatedMovies(): MutableLiveData<List<Movie>> {
        return repository.getTopRatedMovies()
    }


    fun getClassic(): MutableLiveData<List<Movie>> {
        return repository.getClassic()
    }

    fun getNowPlayingMovies(): MutableLiveData<List<Movie>> {
        return repository.getNowPlayingMovies()
    }

    fun getUpcomingMovies(): MutableLiveData<List<Movie>> {
        return repository.getUpcomingMovies()
    }

    fun getPupularMovies(): MutableLiveData<List<Movie>> {
        return repository.getPupularMovies()

    }

}