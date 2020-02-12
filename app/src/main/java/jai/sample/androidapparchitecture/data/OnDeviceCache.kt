package jai.sample.androidapparchitecture.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class OnDeviceCache : RoomDatabase() {
    abstract fun getUserDao() : UserDao
}