package com.andre.agel.sessiontime.presentation.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.andre.agel.sessiontime.data.model.Movie
import com.andre.agel.sessiontime.data.repository.MovieRepository
import io.mockk.coEvery
import io.mockk.mockk
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MoviesViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private val mMovieRepository = mockk<MovieRepository>(relaxed = true)

    private lateinit var moviesViewModel: MoviesViewModel

    @Before
    fun setup(){
        moviesViewModel = MoviesViewModel(mMovieRepository)
    }

    @Test
    fun `quando viewModel getTopRated entao deve chamar repositorio getTopRated`(){
        val mockedMovies = listOf<Movie>()

        //coEvery { mMovieRepository.getTopRatedMovies() } returns mockedMovies
    }


}