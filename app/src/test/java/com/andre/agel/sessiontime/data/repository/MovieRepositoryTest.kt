package com.andre.agel.sessiontime.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.andre.agel.sessiontime.data.database.dao.ActorDao
import com.andre.agel.sessiontime.data.database.dao.MovieDao
import com.andre.agel.sessiontime.data.network.TmdbServices
import com.andre.agel.sessiontime.resources.base.BaseTest
import com.andre.agel.sessiontime.resources.mockedResponses.MockMovieTestResource
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.lang.Thread.sleep
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
    fun `metodo getMovieDetails deve retornar um mutableLivedata de movie da API`() {

        val data = MockMovieTestResource.mockMovie()

        mockNetworkResponseWithFileContent("movieDetails.json", HttpURLConnection.HTTP_OK)
        sut = MovieRepository(mMovieDao, mActorDao,createApi())

        val dataReceived = sut.getMovieDetails(150)

        assertNotNull(dataReceived)
        sleep(500)
        assertEquals(dataReceived.value?.id , data.value?.id)

    }

    @Test
    fun `metodo getTopRatedMovies deve retornar um mutableLivedata de movies da API`() {

        val data = MockMovieTestResource.mockMoviesList()

        mockNetworkResponseWithFileContent("movieList.json", HttpURLConnection.HTTP_OK)
        sut = MovieRepository(mMovieDao, mActorDao,createApi())

        val dataReceived = sut.getTopRatedMovies()

        assertNotNull(dataReceived)
        sleep(500)
        assertEquals(dataReceived.value?.get(1)?.id, data.value?.get(1)?.id)

    }

    @Test
    fun `metodo getClassic deve retornar um mutableLivedata de movies da API`() {

        val data = MockMovieTestResource.mockMoviesList()

        mockNetworkResponseWithFileContent("movieList.json", HttpURLConnection.HTTP_OK)
        sut = MovieRepository(mMovieDao, mActorDao,createApi())

        val dataReceived = sut.getClassic()

        assertNotNull(dataReceived)
        sleep(500)
        assertEquals(dataReceived.value?.get(1)?.id, data.value?.get(1)?.id)

    }

    @Test
    fun `metodo getUpcoming deve retornar um mutableLivedata de movies da API`() {

        val data = MockMovieTestResource.mockMoviesList()

        mockNetworkResponseWithFileContent("movieList.json", HttpURLConnection.HTTP_OK)
        sut = MovieRepository(mMovieDao, mActorDao,createApi())

        val dataReceived = sut.getUpcomingMovies()

        assertNotNull(dataReceived)
        sleep(500)
        assertEquals(dataReceived.value?.get(1)?.id, data.value?.get(1)?.id)

    }

    @Test
    fun `metodo getPopular deve retornar um mutableLivedata de movies da API`() {

        val data = MockMovieTestResource.mockMoviesList()

        mockNetworkResponseWithFileContent("movieList.json", HttpURLConnection.HTTP_OK)
        sut = MovieRepository(mMovieDao, mActorDao,createApi())

        val dataReceived = sut.getPupularMovies()

        assertNotNull(dataReceived)
        sleep(500)
        assertEquals(dataReceived.value?.get(1)?.id, data.value?.get(1)?.id)

    }

    @Test
    fun `metodo getNowPlayng deve retornar um mutableLivedata de movies da API`() {

        val data = MockMovieTestResource.mockMoviesList()

        mockNetworkResponseWithFileContent("movieList.json", HttpURLConnection.HTTP_OK)
        sut = MovieRepository(mMovieDao, mActorDao,createApi())

        val dataReceived = sut.getNowPlayingMovies()

        assertNotNull(dataReceived)
        sleep(500)
        assertEquals(dataReceived.value?.get(1)?.id, data.value?.get(1)?.id)

    }

    @Test
    fun `metodo getRecomendations deve retornar um mutableLivedata de movies da API`() {

        val data = MockMovieTestResource.mockMoviesList()

        mockNetworkResponseWithFileContent("movieList.json", HttpURLConnection.HTTP_OK)
        sut = MovieRepository(mMovieDao, mActorDao,createApi())

        val dataReceived = sut.getMoviesRecommendations(150)

        assertNotNull(dataReceived)
        sleep(500)
        assertEquals(dataReceived.value?.get(1)?.id, data.value?.get(1)?.id)

    }

}