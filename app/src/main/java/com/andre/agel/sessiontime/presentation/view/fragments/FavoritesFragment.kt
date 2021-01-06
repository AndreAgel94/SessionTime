package com.andre.agel.sessiontime.presentation.view.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andre.agel.sessiontime.R
import com.andre.agel.sessiontime.presentation.view.activities.MovieDetailsActivity
import com.andre.agel.sessiontime.presentation.view.adapter.MovieAdapter
import com.andre.agel.sessiontime.presentation.viewModel.FavoritesViewModel
import kotlinx.android.synthetic.main.fragment_favorites.*
import kotlinx.android.synthetic.main.fragment_movie.*
import org.koin.androidx.viewmodel.ext.android.viewModel



class FavoritesFragment : Fragment() {

    val viewModel : FavoritesViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let {
            viewModel.getAllMovies().observe(it, Observer {
                it.let {
                    with(rcFavoritesMovies){
                        layoutManager = GridLayoutManager(
                            activity,
                            2
                        )
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
    }
}