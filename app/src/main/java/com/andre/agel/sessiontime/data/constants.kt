package com.andre.agel.sessiontime.data

import kotlin.random.Random

const val API_KEY = "90ba7fba1e3a871fcf6ea0e3f4afc1f8"

fun rand(start: Int, end: Int): Int {
    require(start <= end) { "Illegal Argument" }
    return Random(System.nanoTime()).nextInt(start, end + 1)
}