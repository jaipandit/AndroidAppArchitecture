package jai.sample.androidapparchitecture.cloud

import jai.sample.androidapparchitecture.data.User
import jai.sample.androidapparchitecture.data.WebService
import retrofit2.Call
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RetrofitWebService @Inject constructor() : WebService {

    override fun getUser(userId: String): Call<User> {
        TODO()
    }
}