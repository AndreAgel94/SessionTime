package com.andre.agel.sessiontime.presentation.view.activities

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.andre.agel.sessiontime.R
import com.andre.agel.sessiontime.presentation.view.adapter.MovieAdapter
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MoviesActivityTest{

    @Test
    fun quando_inicializar_moviesActivity_deve_inflar_HomeFragment(){
        //SETUP
        val activityScenario = ActivityScenario.launch(MoviesActivity::class.java)
        onView(withId(R.id.fragment_movieid)).check(matches(isDisplayed()))
    }

    @Test
    fun quando_clicar_em_iconeFavoritos_deve_inflar_FavoritesFragment(){
        //SETUP
        val activityScenario = ActivityScenario.launch(MoviesActivity::class.java)

        onView(withId(R.id.favoritesBottom)).perform(click())
        onView(withId(R.id.fragment_favoritesid)).check(matches(isDisplayed()))
    }

    @Test
    fun quando_clicar_item_recyclerViewPopular_deve_lancar_detailsActivity(){
        //SETUP
        val activityScenario = ActivityScenario.launch(MoviesActivity::class.java)

        //verificando se o rv está na view
        onView(withId(R.id.rvPopularMovies)).check(matches(isDisplayed()))

        //performando click no item 0
        onView(withId(R.id.rvPopularMovies)).perform(actionOnItemAtPosition<MovieAdapter.MoviesViewHolder>(0, click()))

        //verificando se tela de detalhes é lancada
        onView(withId(R.id.activity_detailsid)).check(matches(isDisplayed()))

    }
}