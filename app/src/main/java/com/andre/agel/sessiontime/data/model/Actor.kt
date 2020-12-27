package com.andre.agel.sessiontime.data.model

data class Actor (
    val adult : Boolean,

    val gender : Int?,

    val id : Int,

    val known_for_department : String,

    val name : String,

    val original_name : String,

    val popularity : Number,

    val profile_path : String?,

    val cast_id : Int,

    val character : String,

    val credit_id : String,

    val order : Int

)