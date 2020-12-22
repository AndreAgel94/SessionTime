package com.andre.agel.sessiontime.data.repository

import androidx.lifecycle.MutableLiveData
import com.andre.agel.sessiontime.data.model.Movie
import com.andre.agel.sessiontime.data.model.MovieResponse
import com.andre.agel.sessiontime.data.network.ApiService
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepository {

    val moviesLivedata : MutableLiveData<List<Movie>> = MutableLiveData()
    val movieLD : MutableLiveData<Movie> = MutableLiveData()

    fun getMovieDetails(): MutableLiveData<Movie> {
            ApiService.services.getMovieDetails(10).enqueue(object : Callback<Movie>{
            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                if(response.isSuccessful){
                    response.body().let {
                        movieLD.value = it
                    }
                }
            }

            override fun onFailure(call: Call<Movie>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

        return movieLD
    }

    fun getTopRatedMovies(): MutableLiveData<List<Movie>> {
        ApiService.services.getTopRatedMovies().enqueue(object : Callback<MovieResponse>{
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if(response.isSuccessful){
                    response.body().let {
                        if (it != null) {
                            moviesLivedata.value = it.results
                        }
                    }
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

            }

        })
        return moviesLivedata
    }

    fun getLatestMovie(): MutableLiveData<Movie> {
        ApiService.services.getLatestMovie().enqueue(object : Callback<Movie>{
            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                if(response.isSuccessful){
                    response.body().let {
                        movieLD.value = it
                    }
                }
            }

            override fun onFailure(call: Call<Movie>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
        return movieLD
    }

    fun getUpcomingMovies(): MutableLiveData<List<Movie>> {
        ApiService.services.getUpcomingMovies().enqueue(object : Callback<MovieResponse>{
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful){
                    response.body().let {
                        if (it != null) {
                            moviesLivedata.value = it.results
                        }
                    }
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
        return moviesLivedata
    }

    fun getPupularMovies(): MutableLiveData<List<Movie>> {
        ApiService.services.getPupularMovies().enqueue(object : Callback<MovieResponse>{
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if(response.isSuccessful){
                    response.body().let {
                        if (it != null) {
                            moviesLivedata.value = it.results
                        }
                    }
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
        return moviesLivedata
    }

    fun getNowPlayingMovies(): MutableLiveData<List<Movie>> {
        ApiService.services.getNowPlayingMovies().enqueue(object : Callback<MovieResponse>{
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful){
                    response.body().let {
                        if (it != null) {
                            moviesLivedata.value = it.results
                        }
                    }
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
        return moviesLivedata
    }
}