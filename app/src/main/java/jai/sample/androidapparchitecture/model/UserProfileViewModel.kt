package jai.sample.androidapparchitecture.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import jai.sample.androidapparchitecture.data.User
import jai.sample.androidapparchitecture.data.UserRepository
import javax.inject.Inject

class UserProfileViewModel @Inject constructor(userRepository: UserRepository) : ViewModel() {
    var userId: String = "-1"
    val userLiveData: LiveData<List<User>> = userRepository.getUsers()
}