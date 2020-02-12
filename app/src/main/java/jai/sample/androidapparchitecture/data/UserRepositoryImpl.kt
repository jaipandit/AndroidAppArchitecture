package jai.sample.androidapparchitecture.data

import androidx.lifecycle.LiveData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl @Inject constructor(private val webService: WebService,
                                             private val userDao: UserDao) : UserRepository {
    override fun getUser(userId: String): LiveData<User> {
        refreshData()
        return userDao.get(userId)
    }

    private fun refreshData() {
        TODO()
    }

}