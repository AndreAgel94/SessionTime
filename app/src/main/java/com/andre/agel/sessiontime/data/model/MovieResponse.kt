package com.andre.agel.sessiontime.data.model

data class MovieResponse (
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Long
)