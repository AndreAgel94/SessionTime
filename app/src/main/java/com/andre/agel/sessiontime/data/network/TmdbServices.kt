package com.andre.agel.sessiontime.data.network

import com.andre.agel.sessiontime.data.API_KEY
import com.andre.agel.sessiontime.data.model.Movie
import com.andre.agel.sessiontime.data.network.response.MovieCreditsResponse
import com.andre.agel.sessiontime.data.network.response.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TmdbServices {

    //BASE_URL https://api.themoviedb.org/3/

    //get the recommendations for a movie
    @GET("movie/{movie_id}/recommendations")
    fun getMoviesRecommendations(
        @Path("movie_id") movie_id : Int,
        @Query("api_key") api_key : String = API_KEY,
        @Query("language") language : String = "en-US",
        @Query("page") page : Int = 1,
    ): Call<MovieResponse>

    //get now playing movies
    @GET("movie/now_playing")
    fun getNowPlayingMovies(
            @Query("api_key") api_key : String = API_KEY,
            @Query("language") language : String = "en-US",
            @Query("page") page : Int = 1,
    ) : Call<MovieResponse>

    //get popular movies
    @GET("movie/popular")
    fun getPupularMovies(
            @Query("api_key") api_key : String = API_KEY,
            @Query("language") language : String = "en-US",
            @Query("page") page : Int = 1,
    ) : Call<MovieResponse>

    // get upcoming movies
    @GET("movie/upcoming")
    fun getUpcomingMovies(
        @Query("api_key") api_key : String = API_KEY,
        @Query("language") language : String = "en-US",
        @Query("page") page : Int = 1,
        ) : Call<MovieResponse>

    //get the latest movie
    @GET("movie/latest")
    fun getLatestMovie(
        @Query("api_key") api_key : String = API_KEY,
        @Query("language") language : String = "en-US",
    ) : Call<Movie>

    //get top rated movies
    @GET("movie/top_rated")
    fun getTopRatedMovies(
        @Query("api_key") api_key : String = API_KEY,
        @Query("language") language : String = "en-US",
        @Query("page") page : Int = 1,
    ) : Call<MovieResponse>

    //get one movie details
    @GET("movie/{movie_id}")
    fun getMovieDetails(
        @Path("movie_id") movie_id : Int,
        @Query("api_key") api_key : String = API_KEY,
        @Query("language") language : String = "en-US",
    ) : Call<Movie>

    //get the credits for a movie
    @GET("movie/{movie_id}/credits")
    fun getMovieCredits(
        @Path("movie_id") movie_id : Int,
        @Query("api_key") api_key : String = API_KEY,
        @Query("language") language : String = "en-US",
    ) : Call<MovieCreditsResponse>


}