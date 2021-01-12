package com.andre.agel.sessiontime.presentation.view.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andre.agel.sessiontime.R
import com.andre.agel.sessiontime.data.model.Movie
import com.andre.agel.sessiontime.presentation.view.adapter.MovieAdapter
import com.andre.agel.sessiontime.presentation.view.adapter.ActorsAdapter
import com.andre.agel.sessiontime.presentation.viewModel.MovieDetailViewModel
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_details.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieDetailsActivity : AppCompatActivity() {

    val viewModel : MovieDetailViewModel by viewModel()
    lateinit var  movieFavorites : Movie


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
                    adapter = ActorsAdapter(it)
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

            this@MovieDetailsActivity.movieFavorites = movie

            //Rating bar
            val ratingValue : Float = (movie.vote_average / 2).toFloat()
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
                        val intent = MovieDetailsActivity.getStartIntent(this@MovieDetailsActivity,it.id)
                        startActivity(intent)
                    }
                }
            }
        })

        star_button.setOnClickListener {
            viewModel.saveMovieDB(movieFavorites)
            Toast.makeText(this,"Add to favorites",Toast.LENGTH_SHORT).show()
            star_button.isLiked = true
            star_button.setAnimationScaleFactor(5.toFloat())
        }
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