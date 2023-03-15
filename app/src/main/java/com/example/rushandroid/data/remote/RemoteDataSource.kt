package com.example.rushandroid.data.remote

import com.example.rushandroid.data.entities.LoginRequest
import com.example.rushandroid.data.entities.RegisterRequest
import com.example.rushandroid.utils.BaseDataSource

import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val api: ServiceAPI
) : BaseDataSource(){

    suspend fun getLogin(req: LoginRequest)
            = getResult { api.login("endpointAPI",req) }

    suspend fun register(req: RegisterRequest)
            = getResult { api.register("endpointAPI",req) }
}
