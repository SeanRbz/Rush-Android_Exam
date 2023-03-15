package com.example.rushandroid

import com.example.rushandroid.data.entities.LoginResponse
import com.example.rushandroid.data.entities.RequestRewards
import com.example.rushandroid.data.entities.Rewards

enum class ResponsesStr (val str:String){
    SuccessLogin("Successfully logged in."),
    FailedLogin("User not found."),
    SuccessRegistration("Successfully registered"),
    FailedRegistration("Registration Failed"),
    ProfileRetrieved("Successfully retrieved user profile"),
    SucessRetrievedRewards("Successfully retrieved rewards")
}


class TestData{
    val arr = arrayListOf<Rewards>(Rewards(
        id = 1,
        name = "Shopee 100Php Off",
        description = "100Php off on Shopee with a minimum purchase of 1000Php!",
        image ="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSjAk8-sic9MUEOpyMJXpnQkbLz2wUMOmUvYep80A8FRbH3bVeb&s"
        ),
        Rewards(
            id = 2,
            name = "Zalora Free Deliveryf",
            description = "1Free delivery on any order from Zalora!",
            image ="https://static-sg.zacdn.com/cms/zaloranow/ZNOW_FA_LOGOS_PRIMARY_BLACK.png"
        )
        )

    val successUser = LoginResponse(
        id ="123-456-789-abc-def",
        first_name = "Mang",
        last_name = "Tani",
        mobile = "9123456789",
        is_verified = false,
        referral_code =  "qwe123")
    val successRewardsQuery: RequestRewards = RequestRewards(200,ResponsesStr.SucessRetrievedRewards.str,arr)
}


