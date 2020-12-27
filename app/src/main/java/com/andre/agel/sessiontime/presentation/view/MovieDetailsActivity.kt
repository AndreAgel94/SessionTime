package com.andre.agel.sessiontime.presentation.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.andre.agel.sessiontime.R
import com.andre.agel.sessiontime.presentation.viewModel.MovieDetailViewModel
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.movie_details.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieDetailsActivity : AppCompatActivity() {

    val viewModel : MovieDetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_details)

        val id = intent.getIntExtra(EXTRA_ID,0)

        viewModel.getMovieActors()

        viewModel.getMovieDetails(id).observe(this, Observer {movie ->
            Glide
                .with(this.applicationContext)
                .load("https://image.tmdb.org/t/p/w185" + movie.poster_path)
                .centerCrop()
                .into(imageView)

            textView2.text = movie.title
            textView3.text = movie.overview

        })
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