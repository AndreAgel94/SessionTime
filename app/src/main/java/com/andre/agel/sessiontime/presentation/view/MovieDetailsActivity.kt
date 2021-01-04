package com.andre.agel.sessiontime.presentation.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andre.agel.sessiontime.R
import com.andre.agel.sessiontime.presentation.view.adapter.MovieAdapter
import com.andre.agel.sessiontime.presentation.view.adapter.MovieDetailsAdapter
import com.andre.agel.sessiontime.presentation.viewModel.MovieDetailViewModel
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.movie_details.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlinx.android.synthetic.main.movie_details.ratingBarDetails as ratingBarDetails1

class MovieDetailsActivity : AppCompatActivity() {

    val viewModel : MovieDetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val id = intent.getIntExtra(EXTRA_ID,0)

        viewModel.getMovieActors(id).observe(this, Observer {
            it.let {
                with(recyclerViewActors){
                    layoutManager = LinearLayoutManager(
                        this@MovieDetailsActivity,
                        RecyclerView.HORIZONTAL,
                        false
                    )
                    adapter = MovieDetailsAdapter(it)
                }
            }
        })

        viewModel.getMovieDetails(id).observe(this, Observer {movie ->
            Glide
                .with(this.applicationContext)
                .load("https://image.tmdb.org/t/p/w500" + movie.backdrop_path)
                .centerCrop()
                .into(imageViewDetails)

            textViewDetailsDate.text = movie.release_date
            textViewDetailsTitle.text = movie.title
            textViewMovieDescription.text = movie.overview

            //Rating bar
            val ratingValue : Float = movie.vote_average / 2
            ratingBarDetails.numStars = 5
            ratingBarDetails.rating = ratingValue
            textViewRatingValue.text = ratingValue.toString()
            Log.i("rating",ratingValue.toString())
           // ratingBarDetails.stepSize = ratingValue

        })

        viewModel.getMoviesRecommendations(id).observe(this, Observer {
            it.let {
                with(rcRelatedMovies) {
                    layoutManager = LinearLayoutManager(
                        this@MovieDetailsActivity,
                        RecyclerView.HORIZONTAL,
                        false
                    )
                    setHasFixedSize(true)

                    adapter = MovieAdapter(it) {
                        // TODO: 29/12/20  call details activity again (recursion)
                        //val intent = MovieDetailsActivity.getStartIntent(this@MovieDetailsActivity,id)


                    }
                }
            }
        })

//        star_button.setOnClickListener {
//
//        }
    }

    companion object {
        private const val EXTRA_ID = "EXTRA_ID"
        fun getStartIntent(context: Context, id : Int): Intent {
            return Intent(context, MovieDetailsActivity::class.java).apply {
                putExtra(EXTRA_ID, id)
            }
        }
    }
}