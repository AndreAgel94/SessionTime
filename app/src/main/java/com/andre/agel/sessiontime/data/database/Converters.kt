package com.andre.agel.sessiontime.data.database

import androidx.room.TypeConverter

class Converters {

    @TypeConverter
    fun fromGenreToString(genres : List<Long>) : String{
        return genres.toString()
    }

//    fun fromStringToGenre(genre: String) : List<Long>{
//        // TODO: 04/01/21 must parse genre to a responseModel
//    }
}