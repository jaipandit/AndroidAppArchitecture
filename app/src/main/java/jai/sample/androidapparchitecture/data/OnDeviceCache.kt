package jai.sample.androidapparchitecture.data

import androidx.room.Database
import androidx.room.RoomDatabase
import java.util.concurrent.Executors

@Database(entities = [User::class], version = 1)
abstract class OnDeviceCache : RoomDatabase() {
    abstract fun getUserDao() : UserDao

    val executor = Executors.newFixedThreadPool(1)

    fun updateDb(function : ()->Unit) {
        executor.execute(function)
    }
}