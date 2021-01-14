package com.andre.agel.sessiontime.presentation.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.andre.agel.sessiontime.data.model.Movie
import com.andre.agel.sessiontime.data.repository.MovieRepository
import io.mockk.every
import io.mockk.mockk
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule

class FavoritesViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val mMovieRepository = mockk<MovieRepository>(relaxed = true)
    private lateinit var sut : FavoritesViewModel

    @Test
    fun getAllMovies() {
        val repositoryResponseLD : MutableLiveData<List<Movie>> = MutableLiveData()
        var viewModelResponseLD : MutableLiveData<List<Movie>> = MutableLiveData()

        every { mMovieRepository.getAllMoviesDB() } returns repositoryResponseLD
        sut = FavoritesViewModel(mMovieRepository)
        viewModelResponseLD = sut.getAllMovies()

        assertNotNull(viewModelResponseLD)
        assertEquals(viewModelResponseLD,repositoryResponseLD)
    }

}