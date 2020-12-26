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


    val movieDetailsLD: MutableLiveData<Movie> = MutableLiveData()
    val moviesTopRatedLD: MutableLiveData<List<Movie>> = MutableLiveData()
    val movieLatestLD: MutableLiveData<Movie> = MutableLiveData()
    val moviesUpcomingLD: MutableLiveData<List<Movie>> = MutableLiveData()
    val moviesPopularLD: MutableLiveData<List<Movie>> = MutableLiveData()
    val moviesPlayngLD: MutableLiveData<List<Movie>> = MutableLiveData()

    fun getMovieDetails(): MutableLiveData<Movie> {
        GlobalScope.launch {
            ApiService.services.getMovieDetails(100).enqueue(object : Callback<Movie> {
                override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                    if (response.isSuccessful) {
                        response.body().let {
                            movieDetailsLD.value = it
                        }
                    }
                }

                override fun onFailure(call: Call<Movie>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
        }

        return movieDetailsLD
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
                                moviesTopRatedLD.value = it.results
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

                }

            })
        }

        return moviesTopRatedLD
    }

    fun getLatestMovie(): MutableLiveData<Movie> {
        GlobalScope.launch {
            ApiService.services.getLatestMovie().enqueue(object : Callback<Movie> {
                override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                    if (response.isSuccessful) {
                        response.body().let {
                            movieLatestLD.value = it
                        }
                    }
                }

                override fun onFailure(call: Call<Movie>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
        }
        return movieLatestLD
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
                                moviesUpcomingLD.value = it.results
                                Log.i("testeupcoming", it.results.toString())

                            }
                        }
                    }
                }

                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
        }

        return moviesUpcomingLD
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
                                moviesPopularLD.value = it.results
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

        return moviesPopularLD
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
                                moviesPlayngLD.value = it.results
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

        return moviesPlayngLD
    }
}