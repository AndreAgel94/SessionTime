package com.andre.agel.sessiontime.presentation.view.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andre.agel.sessiontime.R
import com.andre.agel.sessiontime.presentation.view.activities.MovieDetailsActivity
import com.andre.agel.sessiontime.presentation.view.adapter.MovieAdapter
import com.andre.agel.sessiontime.presentation.viewModel.MoviesViewModel
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_movie.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class MovieFragment : Fragment() {

    val viewModel : MoviesViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let {
            viewModel.getLatestMovie().observe(it, Observer {
                if(!it.adult){
                    Glide
                        .with(requireActivity())
                        .load("https://image.tmdb.org/t/p/w500" + it.poster_path )
                        .centerCrop()
                        .into(imageLatestMovie)
                    textViewLatestTitle.text = it.title
                    //Log.i("poster_path",it.poster_path)

                    imageLatestMovie.setOnClickListener {
                        val intent = MovieDetailsActivity.getStartIntent(requireActivity(), it.id)
                        activity?.startActivity(intent)
                    }
                }

            })
        }

        activity?.let {
            viewModel.getPupularMovies().observe(it, Observer {
                it.let {
                    with(rvPopularMovies){
                        layoutManager = LinearLayoutManager(
                            activity,
                            RecyclerView.HORIZONTAL,
                            false)
                        setHasFixedSize(true)

                        adapter = MovieAdapter(it){
                            Log.i("TestingUnit",it.poster_path)
                            val intent =  MovieDetailsActivity.getStartIntent(requireActivity(), it.id)
                            activity?.startActivity(intent)
                        }

                    }
                }
            })
        }

        activity?.let {
            viewModel.getUpcomingMovies().observe(it, Observer {
                it.let {
                    with(rcUpcomingMovies){
                        layoutManager = LinearLayoutManager(
                            activity,
                            RecyclerView.HORIZONTAL,
                            false)
                        setHasFixedSize(true)

                        adapter = MovieAdapter(it){
                            Log.i("TestingUnit",it.poster_path)
                            val intent = MovieDetailsActivity.getStartIntent(requireActivity(), it.id)
                            activity?.startActivity(intent)
                        }

                    }
                }
            })
        }

        activity?.let {
            viewModel.getTopRatedMovies().observe(it, Observer {
                it.let {
                    with(rcTopRated){
                        layoutManager = LinearLayoutManager(
                            activity,
                            RecyclerView.HORIZONTAL,
                            false)
                        setHasFixedSize(true)

                        adapter = MovieAdapter(it){
                            Log.i("TestingUnit",it.poster_path)
                            val intent = MovieDetailsActivity.getStartIntent(requireActivity(), it.id)
                            activity?.startActivity(intent)
                        }

                    }
                }
            })
        }

        activity?.let {
            viewModel.getNowPlayingMovies().observe(it, Observer {
                it.let {
                    with(rcNowPlaying){
                        layoutManager = LinearLayoutManager(
                            activity,
                            RecyclerView.HORIZONTAL,
                            false)
                        setHasFixedSize(true)

                        adapter = MovieAdapter(it){
                            Log.i("TestingUnit",it.poster_path)
                            val intent = MovieDetailsActivity.getStartIntent(requireActivity(), it.id)
                            activity?.startActivity(intent)
                        }

                    }
                }
            })
        }
    }

}