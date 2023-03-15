package com.example.rushandroid.data.entities

data class RequestUser(
    var status:Int =0,
    var message: String,
    var data: LoginResponse? = null
)
data class RequestRewards(
    var status:Int =0,
    var message: String,
    var list: ArrayList<Rewards>? = arrayListOf()
)

class Rewards(
    val id: Int =0 ,
    val name: String = "",
    val description:String = "",
    val image: String = ""
)

data class LoginRequest (
    var mobile: String = "",
    val mpin: String = ""
)

data class RegisterRequest (
    var first_name: String = "",
    val last_name: String = "",
    var mobile: String = "",
    var mpin: String = ""
)

data class RegisterResponse (
    var status: Int = 200,
    val message: String = "",
    var data: Any? = null
)


//Profile or Login
data class LoginResponse (
    var id: String = "",
    val first_name: String = "",
    var last_name: String = "",
    var mobile: String = "",
    var is_verified: Boolean,
    var referral_code:String
)
