package com.andre.agel.sessiontime.presentation.view.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andre.agel.sessiontime.R
import com.andre.agel.sessiontime.data.model.Movie
import com.andre.agel.sessiontime.presentation.view.activities.MovieDetailsActivity
import com.andre.agel.sessiontime.presentation.view.adapter.FavoritesAdapter
import com.andre.agel.sessiontime.presentation.view.adapter.MovieAdapter
import com.andre.agel.sessiontime.presentation.viewModel.FavoritesViewModel
import kotlinx.android.synthetic.main.fragment_favorites.*
import kotlinx.android.synthetic.main.fragment_movie.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.lang.Thread.sleep


class FavoritesFragment : Fragment() {

    val viewModel: FavoritesViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fetchMovies()
    }

    private fun fetchMovies(){
        activity?.let {
            viewModel.getAllMovies().observe(it, Observer {
                it.let {
                    with(rcFavoritesMovies) {
                        layoutManager = GridLayoutManager(
                            activity,
                            3
                        )
                        setHasFixedSize(true)

                        adapter = FavoritesAdapter(it,
                            {
                                val intent =
                                    MovieDetailsActivity.getStartIntent(requireActivity(), it.id)
                                activity?.startActivity(intent)
                            }) {
                            alertDeleteDialog(it)
                        }

                    }
                }
            })
        }
    }

    private fun alertDeleteDialog(movie: Movie){
        val builder = AlertDialog.Builder(activity)
        builder.setTitle(movie.title)
        builder.setMessage("Do you want to delete this movie from favorites?")

        builder.setPositiveButton("Delete") { dialog, which ->
            deleteMovieDb(movie)
        }

        builder.setNeutralButton("Cancel"){ dialog, which ->

        }

        builder.show()
    }

    private fun deleteMovieDb(movie : Movie){
        viewModel.deleteMovie(movie.id)
        sleep(250)
        fetchMovies()
    }
}