package com.andre.agel.sessiontime.presentation.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.andre.agel.sessiontime.data.model.Actor
import com.andre.agel.sessiontime.data.model.Movie
import com.andre.agel.sessiontime.data.repository.MovieRepository
import com.andre.agel.sessiontime.resources.MockMovieTestResource.mockMovie
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class MovieDetailViewModelTest{

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val mMovieRepository = mockk<MovieRepository>(relaxed = true)
    private lateinit var sut : MovieDetailViewModel

    @Test
    fun `quando chamar viewModel getDetails, deve retornar Repository getDetails`(){

        val repositoryResponseLD : MutableLiveData<Movie> = MutableLiveData()
        var viewModelresponseLD : MutableLiveData<Movie> = MutableLiveData()

        repositoryResponseLD.value = mockMovie()

        every { mMovieRepository.getMovieDetails(150) } returns repositoryResponseLD
        sut = MovieDetailViewModel(mMovieRepository)

        viewModelresponseLD = sut.getMovieDetails(150)

        assertNotNull(viewModelresponseLD)
        assertEquals(viewModelresponseLD,repositoryResponseLD)
    }

    @Test
    fun `quando chamar viewmodel getActors, deve retornar Repository getActors`(){
        val repositoryResponseLD : MutableLiveData<List<Actor>> = MutableLiveData()
        var viewModelResponseLD : MutableLiveData<List<Actor>> = MutableLiveData()


    }
}