package com.andre.agel.sessiontime.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorites")
data class FavoriteMovieEntity (
    val adult: Boolean,

    val backdrop_path: String,

    // val genre_ids: List<Long>,

    @PrimaryKey
    val id: Int,

    val original_language: String,

    val original_title: String,

    val overview: String,

    val popularity: Double,

    val poster_path: String,

    val release_date: String,

    val title: String,

    val video: Boolean,

    val vote_average: Float,

    val vote_count: Long

    )