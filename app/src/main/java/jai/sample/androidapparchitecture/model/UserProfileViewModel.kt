package jai.sample.androidapparchitecture.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import jai.sample.androidapparchitecture.data.User
import jai.sample.androidapparchitecture.data.UserRepository
import javax.inject.Inject

class UserProfileViewModel @Inject constructor(userRepository: UserRepository) : ViewModel() {
    var userId: Int = -1
    val userLiveData: LiveData<User> = userRepository.getUser(userId)
}