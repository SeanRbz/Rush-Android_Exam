package com.example.rushandroid.data.repository

import com.example.rushandroid.data.entities.LoginRequest
import com.example.rushandroid.data.entities.RegisterRequest
import com.example.rushandroid.data.remote.RemoteDataSource
import com.example.rushandroid.utils.performGetOperation
import javax.inject.Inject

class LoginRepository @Inject constructor(private val remote: RemoteDataSource) {

    fun login(req: LoginRequest) = performGetOperation(
        networkCall = { remote.getLogin(req) }
    )

    fun register(req: RegisterRequest) = performGetOperation(
        networkCall = { remote.register(req) }
    )

}