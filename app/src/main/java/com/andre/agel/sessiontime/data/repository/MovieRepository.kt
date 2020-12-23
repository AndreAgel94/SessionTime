package com.andre.agel.sessiontime.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.andre.agel.sessiontime.data.model.Movie
import com.andre.agel.sessiontime.data.model.MovieResponse
import com.andre.agel.sessiontime.data.network.ApiService
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepository {

    val moviesLivedata: MutableLiveData<List<Movie>> = MutableLiveData()
    val movieLD: MutableLiveData<Movie> = MutableLiveData()

    fun getMovieDetails(): MutableLiveData<Movie> {
        GlobalScope.launch {
            ApiService.services.getMovieDetails(100).enqueue(object : Callback<Movie> {
                override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                    if (response.isSuccessful) {
                        response.body().let {
                            movieLD.value = it
                            Log.i("testeXXX", it.toString())

                        }
                    }
                }

                override fun onFailure(call: Call<Movie>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
        }

        return movieLD
    }

    fun getTopRatedMovies(): MutableLiveData<List<Movie>> {
        GlobalScope.launch {
            ApiService.services.getTopRatedMovies().enqueue(object : Callback<MovieResponse> {
                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>
                ) {
                    if (response.isSuccessful) {
                        response.body().let {
                            if (it != null) {
                                moviesLivedata.value = it.results
                                Log.i("teste", it.results.size.toString())
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

                }

            })
        }

        return moviesLivedata
    }

    fun getLatestMovie(): MutableLiveData<Movie> {
        GlobalScope.launch {
            ApiService.services.getLatestMovie().enqueue(object : Callback<Movie> {
                override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                    if (response.isSuccessful) {
                        response.body().let {
                            movieLD.value = it
                            Log.i("teste", it.toString())

                        }
                    }
                }

                override fun onFailure(call: Call<Movie>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
        }
        return movieLD
    }

    fun getUpcomingMovies(): MutableLiveData<List<Movie>> {
        GlobalScope.launch {
            ApiService.services.getUpcomingMovies().enqueue(object : Callback<MovieResponse> {
                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>
                ) {
                    if (response.isSuccessful) {
                        response.body().let {
                            if (it != null) {
                                moviesLivedata.value = it.results
                                Log.i("teste2", it.results.size.toString())

                            }
                        }
                    }
                }

                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
        }

        return moviesLivedata
    }

    fun getPupularMovies(): MutableLiveData<List<Movie>> {
        GlobalScope.launch {
            ApiService.services.getPupularMovies().enqueue(object : Callback<MovieResponse> {
                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>
                ) {
                    if (response.isSuccessful) {
                        response.body().let {
                            if (it != null) {
                                moviesLivedata.value = it.results
                                Log.i("teste3", it.results.size.toString())

                            }
                        }
                    }
                }

                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
        }

        return moviesLivedata
    }

    fun getNowPlayingMovies(): MutableLiveData<List<Movie>> {
        GlobalScope.launch {
            ApiService.services.getNowPlayingMovies().enqueue(object : Callback<MovieResponse> {
                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>
                ) {
                    if (response.isSuccessful) {
                        response.body().let {
                            if (it != null) {
                                moviesLivedata.value = it.results
                                Log.i("teste4", it.results.size.toString())

                            }
                        }
                    }
                }

                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
        }

        return moviesLivedata
    }
}