package jai.sample.androidapparchitecture.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface WebService {

    @GET("/users/{user}")
    fun getUser(@Path("user") userId: Int): Call<User>

    @GET("/posts")
    fun getUsers() : Call<List<User>>
}