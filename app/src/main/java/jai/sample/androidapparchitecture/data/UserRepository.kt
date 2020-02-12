package jai.sample.androidapparchitecture.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(val webService: WebService, val onDeviceCache: OnDeviceCache) {

    fun getUser(userId: Int): LiveData<User> {
        val data = MutableLiveData<User>()
        webService.getUser(userId.toString()).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                data.value = response.body()
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                TODO()
            }
        })
        return data
    }
}