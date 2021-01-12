package com.andre.agel.sessiontime.presentation.view.activities

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.andre.agel.sessiontime.R
import com.andre.agel.sessiontime.presentation.view.adapter.MovieAdapter
import com.andre.agel.sessiontime.resources.ToastMatcher
import kotlinx.android.synthetic.main.activity_details.view.*
import kotlinx.coroutines.delay
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.Thread.sleep

@RunWith(AndroidJUnit4ClassRunner::class)
class MovieDetailsActivityTest{

    @Test
    fun quando_clicar_coracaoFavoritos_deve_lancar_Toast_favoritos(){
        //SETUP
        val activityScenario = ActivityScenario.launch(MoviesActivity::class.java)
        sleep(1000)

        //performando click no item 0
        onView(withId(R.id.rvPopularMovies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<MovieAdapter.MoviesViewHolder>(
                1,
                click()
            )
        )

        onView(withId(R.id.star_button)).perform(click())

        onView(withText("Add to favorites"))
            .inRoot(ToastMatcher())
            .check(matches(isDisplayed()))

    }

    @Test
    fun quando_clicar_filmesRelacionados_deve_chamar_Detalhes(){
        //SETUP
        val activityScenario = ActivityScenario.launch(MoviesActivity::class.java)
        sleep(1000)

        //performando click no item 0
        onView(withId(R.id.rvPopularMovies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<MovieAdapter.MoviesViewHolder>(
                1,
                click()
            )
        )
        sleep(1000)

        onView(withId(R.id.activity_detailsid))
            .perform(ViewActions.scrollTo())

        sleep(1000)

        onView(withId(R.id.rcRelatedMovies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<MovieAdapter.MoviesViewHolder>(
                1,
                click()
            )
        )


    }
}