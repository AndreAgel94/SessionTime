package com.andre.agel.sessiontime.presentation.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andre.agel.sessiontime.R
import com.andre.agel.sessiontime.data.model.Movie
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_recycler_list_img.view.*

class MovieAdapter(
    private val movieList : List<Movie>,
    private val OnItemClickListener : ((movie : Movie) -> Unit)
) : RecyclerView.Adapter<MovieAdapter.MoviesViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MoviesViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_list_img,parent,false)

        return MoviesViewHolder(itemView,OnItemClickListener)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    class MoviesViewHolder(
        itemView: View,
        private val OnItemClickListener : ((movie : Movie) -> Unit)
    ) : RecyclerView.ViewHolder(itemView) {

        private val movieTitle = itemView.movieTitle
        private val movieDate = itemView.movieDate
        private val moviePoster = itemView.roundedImageView


        fun bind(movie : Movie){

            movieTitle.text = movie.original_title
            movieDate.text = movie.release_date

            Glide
                .with(itemView)
                .load("https://image.tmdb.org/t/p/w185" + movie.poster_path)
                .centerCrop()
                .into(moviePoster)

            itemView.setOnClickListener {
                OnItemClickListener.invoke(movie)
            }
        }
    }


}