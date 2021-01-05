package com.andre.agel.sessiontime.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.andre.agel.sessiontime.data.database.entity.FavoriteMovieEntity

@Dao
interface FavoriteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveFavorite(favorite : FavoriteMovieEntity)

    @Query("SELECT * FROM favorites")
    suspend fun getFavorites() : List<FavoriteMovieEntity>

}