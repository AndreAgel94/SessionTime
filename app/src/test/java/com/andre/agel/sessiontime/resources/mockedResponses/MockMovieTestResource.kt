package com.andre.agel.sessiontime.resources.mockedResponses

import androidx.lifecycle.MutableLiveData
import com.andre.agel.sessiontime.data.model.Actor
import com.andre.agel.sessiontime.data.model.Movie
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

object MockMovieTestResource {

// OS MOCKS DE MOVIES SÓ ESTAO COM O CAMPO ID FIEL AO JSON DA API

    val movieLD: MutableLiveData<Movie> = MutableLiveData()
    val moviesListLD: MutableLiveData<List<Movie>> = MutableLiveData()

    fun mockMovie(): MutableLiveData<Movie> {
        GlobalScope.launch {
            val movie = Movie(
                id = 150,
                title = "48 Hrs.",
                overview = "A hard-nosed cop reluctantly teams up with a wise-cracking criminal temporarily paroled to him, in order to track down a killer.",
                poster_path = "/8Dlcb8aDch6sUcWBc8zSSfNbPgG.jpg",
                backdrop_path = "/dEoWt93RHoXWb0bKyetX0l25SaM.jpg",
                adult = false,
                release_date = "1982-12-07",
                popularity = 82.991,
                video = false,
                vote_average = 6.7,
                vote_count = 899,
                original_language = "en",
                original_title = "48 Hrs."
            )
            movieLD.value = movie
        }
        return movieLD
    }

    fun mockMoviesList(): MutableLiveData<List<Movie>> {
        val movieList: List<Movie>
        movieList = listOf(
            Movie(
                adult = false,
                backdrop_path = "/fQq1FWp1rC89xDrRMuyFJdFUdMd.jpg",
                id = 761053,
                original_language = "en",
                original_title = "Gabriel's Inferno Part III",
                overview = "The final part of the film adaption of the erotic romance novel Gabriel's Inferno written by an anonymous Canadian author under the pen name Sylvain Reynard.",
                popularity = 40.303,
                poster_path = "/fYtHxTxlhzD4QWfEbrC1rypysSD.jpg",
                release_date = "2020-11-19",
                title = "Gabriel's Inferno Part III",
                video = false,
                vote_average = 9.1,
                vote_count = 602
            ),
            Movie(
                adult = false,
                backdrop_path = "/jtAI6OJIWLWiRItNSZoWjrsUtmi.jpg",
                id = 724089,
                original_language = "en",
                original_title = "Gabriel's Inferno Part II",
                overview = "Professor Gabriel Emerson finally learns the truth about Julia Mitchell's identity, but his realization comes a moment too late. Julia is done waiting for the well-respected Dante specialist to remember her and wants nothing more to do with him. Can Gabriel win back her heart before she finds love in another's arms?",
                popularity = 7.58,
                poster_path = "/pci1ArYW7oJ2eyTo2NMYEKHHiCP.jpg",
                release_date = "2020-07-31",
                title = "Gabriel's Inferno Part II",
                video = false,
                vote_average = 8.9,
                vote_count = 1112
            )
        )
        moviesListLD.value = movieList
        return moviesListLD
    }
}