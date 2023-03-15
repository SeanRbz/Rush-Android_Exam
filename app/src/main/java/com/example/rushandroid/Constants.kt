package com.example.rushandroid

import com.example.rushandroid.data.entities.LoginResponse
import com.example.rushandroid.data.entities.RequestRewards
import com.example.rushandroid.data.entities.RequestUser
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

    val resetRequestUser = RequestUser(0,"",null)
    val arr = arrayListOf<Rewards>(
        Rewards(
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
        ),
        Rewards(
            id = 3,
            name = "Jolibee 10% Off",
            description = "10% off for every 1500 worth pf Puchase",
            image ="https://queen.jollibee.com.ph/2022/02/jollibee-logo-footer-2x.png"
        ),
        Rewards(
            id = 4,
            name = "Free Mang Tomas",
            description = "Free 1 Bottle of Mang Tomas for Every 10 Purchase",
            image ="https://d2t3trus7wwxyy.cloudfront.net/catalog/product/m/a/mang-tomas-lechon-sauce-regular-12-oz_1.jpg"
        ),
        Rewards(
            id = 5,
            name = "Free 500 Robux",
            description = "Free 500 Robux if you buy 1500 robux",
            image ="https://cf.shopee.ph/file/408fe817d727364e0defea1c7dca285f"
        ),
        Rewards(
            id = 6,
            name = "100 Peso Rebate",
            description = "Gcash Rebate upto 100 Peso if you buy a load worth 5000",
            image ="https://www.rbcauayan.com/ssl/images/gcash.jpg"
        ),
        Rewards(
            id = 7,
            name = "10% Rebate",
            description = "10% Rebate for Every purchase of GiGA Video",
            image ="https://smart.com.ph/Prepaid/images/default-source/doublegiga/banner_mobile.png"
        ),
        Rewards(
            id = 8,
            name = "GAP Buy One get One + 10% Reward",
            description = "Available only on selected stores",
            image ="https://lzd-img-global.slatic.net/g/p/f56485732077bd565da927ff2bd1b225.png_2200x2200q80.png_.webp"
        ),
        Rewards(
            id = 9,
            name = "500 Miles on your next purchase",
            description = "Free 500 miles on your next purchase if you buy a ticket  5000+ from Dec 1 - Dec 30",
            image ="https://www.philippineairlines.com/-/media/images/new-pal-mm-web-images/" +
                    "mabuhay-miles-pages/mm-cards/split_container/png/" +
                    "mm_classic_card_split_container_desktop_552x440.png?h=440&w=552&hash=793EF2EE68EAB3E3F71395B9B7060233"
        ),
        Rewards(
            id = 10,
            name = "Double the miles",
            description = "Doubles the miles for every ticket purchase from Dec 20 - Dec 25",
            image ="https://www.travelcodex.com/wp-content/uploads/2015/04/krisflyer-470.jpg"
        ),
        Rewards(
            id = 11,
            name = "10% Rewards for Every Phuket Thailand Tour",
            description = "Get a 10% Rewards if you purchase a Phuket Thailand Tour With Us",
            image ="https://www.planetware.com/photos-large/THA/phuket-day-trips-phi-phi-islands.jpg"
        ),
        Rewards(
            id = 12,
            name = "25% off Sentosa Cable Car",
            description = "25% off on your next Sentosa Ride",
            image ="https://res.klook.com/image/upload/c_fill,w_720,h_500,f_auto/" +
                    "w_80,x_15,y_15,g_south_west,l_klook_water/activities/30870e7d-Singapore-Cable-Car-Skypass.webp"
        ),
        Rewards(
            id = 13,
            name = "24/7 Chicken Free Delivery",
            description = "Free delivery on any order from 24/7 Chicken!",
            image ="https://jontotheworld.com/wp-content/uploads/2021/12/24-Chicken-3.jpg"
        ),
        Rewards(
            id = 14,
            name = "Penang Hills 10% off",
            description = "10% off for Penang Hill Train Ticket purchase",
            image ="https://dynamic-media-cdn.tripadvisor.com/media/photo-o/1b/4b/a4/10/caption.jpg?w=300&h=300&s=1"
        ),
        Rewards(
            id = 15,
            name = "Free Shuttle Gardens By the Bay",
            description = "Free Shuttle to Gardens By the Bay from selected locations",
            image ="https://d3iso9mq9tb10q.cloudfront.net/magefan_blog/g/a/gardens-by-the-bay_article.jpg"
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


