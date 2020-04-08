package jai.sample.androidapparchitecture.cloud

import jai.sample.androidapparchitecture.data.User
import jai.sample.androidapparchitecture.data.WebService
import retrofit2.Call
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Abstracting the network library we are using.
 */
@Singleton
class UserWebService @Inject constructor(private val retrofit: Retrofit) : WebService {

    override fun getUser(userId: Int): Call<User> = retrofit.create(WebService::class.java).getUser(userId)

    override fun getUsers(): Call<List<User>> = retrofit.create(WebService::class.java).getUsers()

}