package com.andre.agel.sessiontime.presentation.viewModel

import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
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

        val mockedLiveData : MutableLiveData<Movie> = MutableLiveData()
        var mockedMovieLiveData : MutableLiveData<Movie> = MutableLiveData()

        mockedLiveData.value = mockMovie()

        every { mMovieRepository.getMovieDetails(150) } returns mockedLiveData
        sut = MovieDetailViewModel(mMovieRepository)

        mockedMovieLiveData = sut.getMovieDetails(150)

        assertNotNull(mockedMovieLiveData)
        assertEquals(mockedMovieLiveData,mockedLiveData)

        // preciso cirar um mutable para receber o getdetails do viewmodel, e depois verificar se ele
        // é igual ao mutable que eu mockei na resposta do repository
    }
}