package jai.sample.androidapparchitecture.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface UserDao {

    @Insert(onConflict = REPLACE)
    fun insert(user: User)

    @Insert(onConflict = REPLACE)
    fun insert(users: List<User>)

    @Query("SELECT * from user WHERE id = :userId")
    fun get(userId: String): LiveData<User>

    @Query("SELECT * from user")
    fun getUsers() : LiveData<List<User>>
}