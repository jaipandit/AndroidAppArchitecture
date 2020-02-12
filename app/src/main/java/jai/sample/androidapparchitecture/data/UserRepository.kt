package jai.sample.androidapparchitecture.data

import androidx.lifecycle.LiveData

interface UserRepository {
    fun getUser(userId: String): LiveData<User>
}