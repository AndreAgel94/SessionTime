package com.andre.agel.sessiontime.presentation.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andre.agel.sessiontime.R
import com.andre.agel.sessiontime.presentation.view.adapter.MovieAdapter
import com.andre.agel.sessiontime.presentation.viewModel.MoviesViewModel
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MoviesActivity : AppCompatActivity() {

    val viewModel : MoviesViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getLatestMovie().observe(this, Observer {
            Glide
                .with(this.applicationContext)
                .load("https://image.tmdb.org/t/p/w500" + it.poster_path )
                .centerCrop()
                .into(imageLatestMovie)

            if(!it.adult){
                textViewLatestTitle.text = it.title
                //Log.i("poster_path",it.poster_path)

                imageLatestMovie.setOnClickListener {
                    val intent = MovieDetailsActivity.getStartIntent(this@MoviesActivity, it.id)
                    this@MoviesActivity.startActivity(intent)
                }
            }

        })

        viewModel.getPupularMovies().observe(this, Observer {
            it.let {
                with(rvPopularMovies){
                    layoutManager = LinearLayoutManager(
                        this@MoviesActivity,
                        RecyclerView.HORIZONTAL,
                        false)
                    setHasFixedSize(true)

                    adapter = MovieAdapter(it){
                        Log.i("TestingUnit",it.poster_path)
                        val intent = MovieDetailsActivity.getStartIntent(this@MoviesActivity, it.id)
                        this@MoviesActivity.startActivity(intent)
                    }

                }
            }
        })

        viewModel.getUpcomingMovies().observe(this, Observer {
            it.let {
                with(rcUpcomingMovies){
                    layoutManager = LinearLayoutManager(
                        this@MoviesActivity,
                        RecyclerView.HORIZONTAL,
                        false)
                    setHasFixedSize(true)

                    adapter = MovieAdapter(it){
                        Log.i("TestingUnit",it.poster_path)
                        val intent = MovieDetailsActivity.getStartIntent(this@MoviesActivity, it.id)
                        this@MoviesActivity.startActivity(intent)
                    }

                }
            }
        })

        viewModel.getTopRatedMovies().observe(this, Observer {
            it.let {
                with(rcTopRated){
                    layoutManager = LinearLayoutManager(
                        this@MoviesActivity,
                        RecyclerView.HORIZONTAL,
                        false)
                    setHasFixedSize(true)

                    adapter = MovieAdapter(it){
                        Log.i("TestingUnit",it.poster_path)
                        val intent = MovieDetailsActivity.getStartIntent(this@MoviesActivity, it.id)
                        this@MoviesActivity.startActivity(intent)
                    }

                }
            }
        })

        viewModel.getNowPlayingMovies().observe(this, Observer {
            it.let {
                with(rcNowPlaying){
                    layoutManager = LinearLayoutManager(
                        this@MoviesActivity,
                        RecyclerView.HORIZONTAL,
                        false)
                    setHasFixedSize(true)

                    adapter = MovieAdapter(it){
                        Log.i("TestingUnit",it.poster_path)
                        val intent = MovieDetailsActivity.getStartIntent(this@MoviesActivity, it.id)
                        this@MoviesActivity.startActivity(intent)
                    }

                }
            }
        })
    }
}