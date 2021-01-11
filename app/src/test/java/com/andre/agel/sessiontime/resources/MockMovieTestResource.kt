package com.andre.agel.sessiontime.resources

import androidx.lifecycle.MutableLiveData
import com.andre.agel.sessiontime.data.model.Movie

object MockMovieTestResource{

    fun mockMovie(): Movie = Movie(
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

}