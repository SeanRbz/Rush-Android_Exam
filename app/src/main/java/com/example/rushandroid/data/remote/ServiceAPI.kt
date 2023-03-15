package com.example.rushandroid.data.remote

import com.example.rushandroid.data.entities.LoginRequest
import com.example.rushandroid.data.entities.LoginResponse
import com.example.rushandroid.data.entities.RegisterRequest
import com.example.rushandroid.data.entities.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path

interface ServiceAPI {

    @GET("{endpoint}")
    suspend fun login(
        @Path("endpoint") endPoint: String,
        @Body details: LoginRequest
    ): Response<LoginResponse>


    @GET("{endpoint}")
    suspend fun register(
        @Path("endpoint") endPoint: String,
        @Body details: RegisterRequest
    ): Response<RegisterResponse>
}