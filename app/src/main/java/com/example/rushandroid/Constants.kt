package com.example.rushandroid

enum class ResponsesStr (val str:String){
    SuccessLogin("Successfully logged in."),
    FailedLogin("User not found."),
    SuccessRegistration("Successfully registered"),
    FailedRegistration("Registration Failed"),
    ProfileRetrieved("Successfully retrieved user profile"),
    RetrievedRewards("Successfully retrieved rewards")

}