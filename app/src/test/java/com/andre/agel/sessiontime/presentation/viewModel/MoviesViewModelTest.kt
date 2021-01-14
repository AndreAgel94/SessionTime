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

class MoviesViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val mMovieRepository = mockk<MovieRepository>(relaxed = true)
    private lateinit var sut : MoviesViewModel

    @Test
    fun getTopRatedMovies() {
        val repositoryResponseLD : MutableLiveData<List<Movie>> = MutableLiveData()
        var viewModelResponseLD : MutableLiveData<List<Movie>> = MutableLiveData()

        every { mMovieRepository.getTopRatedMovies() } returns repositoryResponseLD
        sut = MoviesViewModel(mMovieRepository)
        viewModelResponseLD = sut.getTopRatedMovies()

        assertNotNull(viewModelResponseLD)
        assertEquals(viewModelResponseLD,repositoryResponseLD)
    }

    @Test
    fun getClassic() {
        val repositoryResponseLD : MutableLiveData<List<Movie>> = MutableLiveData()
        var viewModelResponseLD : MutableLiveData<List<Movie>> = MutableLiveData()

        every { mMovieRepository.getClassic() } returns repositoryResponseLD
        sut = MoviesViewModel(mMovieRepository)
        viewModelResponseLD = sut.getClassic()

        assertNotNull(viewModelResponseLD)
        assertEquals(viewModelResponseLD,repositoryResponseLD)
    }

    @Test
    fun getNowPlayingMovies() {
        val repositoryResponseLD : MutableLiveData<List<Movie>> = MutableLiveData()
        var viewModelResponseLD : MutableLiveData<List<Movie>> = MutableLiveData()

        every { mMovieRepository.getNowPlayingMovies() } returns repositoryResponseLD
        sut = MoviesViewModel(mMovieRepository)
        viewModelResponseLD = sut.getNowPlayingMovies()

        assertNotNull(viewModelResponseLD)
        assertEquals(viewModelResponseLD,repositoryResponseLD)
    }

    @Test
    fun getUpcomingMovies() {
        val repositoryResponseLD : MutableLiveData<List<Movie>> = MutableLiveData()
        var viewModelResponseLD : MutableLiveData<List<Movie>> = MutableLiveData()

        every { mMovieRepository.getUpcomingMovies() } returns repositoryResponseLD
        sut = MoviesViewModel(mMovieRepository)
        viewModelResponseLD = sut.getUpcomingMovies()

        assertNotNull(viewModelResponseLD)
        assertEquals(viewModelResponseLD,repositoryResponseLD)
    }

    @Test
    fun getPupularMovies() {
        val repositoryResponseLD : MutableLiveData<List<Movie>> = MutableLiveData()
        var viewModelResponseLD : MutableLiveData<List<Movie>> = MutableLiveData()

        every { mMovieRepository.getPupularMovies() } returns repositoryResponseLD
        sut = MoviesViewModel(mMovieRepository)
        viewModelResponseLD = sut.getPupularMovies()

        assertNotNull(viewModelResponseLD)
        assertEquals(viewModelResponseLD,repositoryResponseLD)
    }
}