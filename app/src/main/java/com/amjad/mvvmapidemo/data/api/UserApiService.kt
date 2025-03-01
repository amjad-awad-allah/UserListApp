package com.amjad.mvvmapidemo.data.api

import com.amjad.mvvmapidemo.data.model.User
import retrofit2.http.GET

// Interface for defining API endpoints
interface UserApiService {

    @GET("users") // Endpoint for fetching users
    suspend fun getUsers(): List<User>
}