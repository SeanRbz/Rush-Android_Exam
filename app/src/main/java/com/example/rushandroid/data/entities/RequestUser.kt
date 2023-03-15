package com.example.rushandroid.data.entities

data class RequestUser(
    var status:Int =0,
    var message: String,
    var data: Users? = null
)