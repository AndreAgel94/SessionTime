package com.andre.agel.sessiontime.data.repository

import androidx.lifecycle.MutableLiveData
import com.andre.agel.sessiontime.data.database.dao.ActorDao
import com.andre.agel.sessiontime.data.database.dao.MovieDao
import com.andre.agel.sessiontime.data.model.Actor
import com.andre.agel.sessiontime.data.model.Movie
import com.andre.agel.sessiontime.data.network.TmdbServices
import com.andre.agel.sessiontime.data.network.response.MovieCreditsResponse
import com.andre.agel.sessiontime.data.network.response.MovieResponse
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepository(
    private val movieDao: MovieDao,
    private val actorDao: ActorDao,
    private val tmdb: TmdbServices
) {

    val movieDetailsLD: MutableLiveData<Movie> = MutableLiveData()
    val moviesTopRatedLD: MutableLiveData<List<Movie>> = MutableLiveData()
    val movieLatestLD: MutableLiveData<Movie> = MutableLiveData()
    val moviesUpcomingLD: MutableLiveData<List<Movie>> = MutableLiveData()
    val moviesPopularLD: MutableLiveData<List<Movie>> = MutableLiveData()
    val moviesPlayngLD: MutableLiveData<List<Movie>> = MutableLiveData()
    val moviesRecommended: MutableLiveData<List<Movie>> = MutableLiveData()
    val moviesclassic: MutableLiveData<List<Movie>> = MutableLiveData()
    val movieActorsLD: MutableLiveData<List<Actor>> = MutableLiveData()

    val allmoviesDB: MutableLiveData<List<Movie>> = MutableLiveData()

    fun saveMovieDB(movie: Movie) {
        GlobalScope.launch { movieDao.save(movie) }
    }

    fun deleteMovieDb(id: Int) {
        GlobalScope.launch {
            movieDao.deleteMovie(id)
        }
    }

    fun getAllMoviesDB(): MutableLiveData<List<Movie>> {
        GlobalScope.launch { allmoviesDB.postValue(movieDao.getAllMovies()) }
        return allmoviesDB
    }


    fun getMovieDetails(id: Int): MutableLiveData<Movie> {

        tmdb.getMovieDetails(id).enqueue(object : Callback<Movie> {
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


        return movieDetailsLD
    }

    fun getTopRatedMovies(): MutableLiveData<List<Movie>> {
        GlobalScope.launch {
            tmdb.getTopRatedMovies().enqueue(object : Callback<MovieResponse> {
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


    fun getClassic(): MutableLiveData<List<Movie>> {
        GlobalScope.launch {
            tmdb.getMoviesClassic().enqueue(object : Callback<MovieResponse> {
                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>
                ) {
                    if (response.isSuccessful) {
                        response.body().let {
                            if (it != null) {
                                moviesclassic.value = it.results
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
        }
        return moviesclassic
    }

    fun getUpcomingMovies(): MutableLiveData<List<Movie>> {
        GlobalScope.launch {
            tmdb.getUpcomingMovies().enqueue(object : Callback<MovieResponse> {
                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>
                ) {
                    if (response.isSuccessful) {
                        response.body().let {
                            if (it != null) {
                                moviesUpcomingLD.value = it.results

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
            tmdb.getPupularMovies().enqueue(object : Callback<MovieResponse> {
                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>
                ) {
                    if (response.isSuccessful) {
                        response.body().let {
                            if (it != null) {
                                moviesPopularLD.value = it.results
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
            tmdb.getNowPlayingMovies().enqueue(object : Callback<MovieResponse> {
                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>
                ) {
                    if (response.isSuccessful) {
                        response.body().let {
                            if (it != null) {
                                moviesPlayngLD.value = it.results


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

    fun getMoviesRecommendations(id: Int): MutableLiveData<List<Movie>> {
        GlobalScope.launch {
            tmdb.getMoviesRecommendations(id).enqueue(object : Callback<MovieResponse> {
                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>
                ) {
                    if (response.isSuccessful) {
                        response.body().let {
                            if (it != null) {
                                moviesRecommended.value = it.results

                            }
                        }
                    }
                }

                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
        }
        return moviesRecommended
    }

    fun getMovieActors(id: Int): MutableLiveData<List<Actor>> {
        GlobalScope.launch {
            tmdb.getMovieCredits(id).enqueue(object : Callback<MovieCreditsResponse> {
                override fun onResponse(
                    call: Call<MovieCreditsResponse>,
                    response: Response<MovieCreditsResponse>
                ) {
                    if (response.isSuccessful) {
                        response.body().let {
                            if (it != null) {
                                movieActorsLD.value = it.cast

                            }
                        }
                    }
                }

                override fun onFailure(call: Call<MovieCreditsResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }


            })
        }
        return movieActorsLD
    }
}