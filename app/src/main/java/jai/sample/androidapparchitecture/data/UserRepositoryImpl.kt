package jai.sample.androidapparchitecture.data

import android.util.Log
import androidx.lifecycle.LiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl @Inject constructor(private val webService: WebService,
                                             private val userDao: UserDao,
                                             private val cache: OnDeviceCache) : UserRepository {
    override fun getUser(userId: String): LiveData<User> {
        return userDao.get(userId)
    }

    override fun getUsers(): LiveData<List<User>> {
        refreshData()
        return userDao.getUsers()
    }

    private fun refreshData() {
        webService.getUsers().enqueue(object : Callback<List<User>> {
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Log.e("JAI", "Failed")
            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if(response.isSuccessful) {
                    cache.updateDb { userDao.insert(response.body()!!) }
                }
            }
        })
    }

}