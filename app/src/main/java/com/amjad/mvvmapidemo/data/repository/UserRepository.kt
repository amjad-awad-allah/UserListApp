package com.amjad.mvvmapidemo.data.repository


import com.amjad.mvvmapidemo.data.api.UserApiService
import com.amjad.mvvmapidemo.data.model.User
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class UserRepository {

    private val apiService: UserApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/") // Base URL for JSONPlaceholder
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(UserApiService::class.java)
    }

    // Fetch users from the API
    suspend fun fetchUsers(): List<User> {
        return apiService.getUsers()
    }
}