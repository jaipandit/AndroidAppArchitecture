package jai.sample.androidapparchitecture.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import dagger.Module
import dagger.Provides
import jai.sample.androidapparchitecture.cloud.RetrofitWebService
import jai.sample.androidapparchitecture.data.*
import javax.inject.Singleton

@Module
class DataModule(application: Application) {

    private val onDeviceCache: OnDeviceCache = Room.databaseBuilder(application, OnDeviceCache::class.java, "demo-db").build()

    @Provides
    @Singleton
    fun getOnDeviceCache(): OnDeviceCache {
        return onDeviceCache
    }

    @Provides
    @Singleton
    fun getUserDao(onDeviceCache: OnDeviceCache): UserDao {
        return onDeviceCache.getUserDao()
    }

    @Provides
    @Singleton
    fun provideUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository {
        return userRepositoryImpl
    }

    @Provides
    @Singleton
    fun provideUserWebService(retrofitWebService: RetrofitWebService): WebService {
        return retrofitWebService
    }
}