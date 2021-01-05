package com.andre.agel.sessiontime.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.andre.agel.sessiontime.data.model.Actor

@Dao
interface ActorDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(actor : Actor)

    @Query("SELECT * FROM actor WHERE id = :id")
    suspend fun getMovieById(id : Int) : Actor
}