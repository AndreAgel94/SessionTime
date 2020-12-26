package com.andre.agel.sessiontime.presentation.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andre.agel.sessiontime.R
import com.andre.agel.sessiontime.presentation.viewModel.MoviesViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MoviesActivity : AppCompatActivity() {

    val viewModel : MoviesViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
                    }

                }
            }
        })
    }
}