package com.andre.agel.sessiontime.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.andre.agel.sessiontime.data.database.dao.ActorDao
import com.andre.agel.sessiontime.data.database.dao.MovieDao
import com.andre.agel.sessiontime.data.model.Movie
import com.andre.agel.sessiontime.data.network.TmdbServices
import com.andre.agel.sessiontime.resources.base.BaseTest
import com.andre.agel.sessiontime.resources.mockedResponses.MockMovieTestResource
import com.andre.agel.sessiontime.resources.mockedResponses.MockResponseFileReader
import com.google.gson.Gson
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.HttpURLConnection

class MovieRepositoryTest : BaseTest() {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    //mock the dao's
    private val mMovieDao = mockk<MovieDao>(relaxed = true)
    private val mActorDao = mockk<ActorDao>(relaxed = true)

    //lateinit repository instance
    lateinit var tmdbServices : TmdbServices
    lateinit var sut : MovieRepository

    @Before
    fun setup(){
        setUp()

    }

    @Test
    fun `metodo getMovieDetails deve retornar um mutableLivedata de movie da API`() = runBlocking{
        val data : MutableLiveData<Movie> = MutableLiveData()
        data.value = MockMovieTestResource.mockMovie()

       // val dataRecived : MutableLiveData<Movie> = MutableLiveData()

        mockNetworkResponseWithFileContent("movieDetails.json", HttpURLConnection.HTTP_OK)
        sut = MovieRepository(mMovieDao, mActorDao,createApi())

       // coEvery { sut.getMovieDetails(150) } returns dataRecived

        val dataRecived : MutableLiveData<Movie> = sut.getMovieDetails(150)

        assertNotNull(dataRecived)
        assertEquals(dataRecived.value?.id , data.value?.id)

    }


}