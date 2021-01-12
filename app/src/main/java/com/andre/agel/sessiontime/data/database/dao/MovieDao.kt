package com.andre.agel.sessiontime.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.andre.agel.sessiontime.data.model.Movie

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(movie : Movie)

    @Query("SELECT * FROM movie WHERE id = :id")
    suspend fun getMovieById(id : Int) : Movie

    @Query("DELETE FROM movie WHERE id = :id")
    suspend fun deleteMovie(id: Int)

    @Query("SELECT * FROM movie")
    suspend fun getAllMovies() : List<Movie>
}