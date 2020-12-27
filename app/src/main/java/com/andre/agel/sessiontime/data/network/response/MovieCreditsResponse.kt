package com.andre.agel.sessiontime.data.network.response

import com.andre.agel.sessiontime.data.model.Actor
import com.andre.agel.sessiontime.data.model.crew

data class MovieCreditsResponse (
    val id : Int,
    val cast : List<Actor>,
    val crew : List<crew>
)