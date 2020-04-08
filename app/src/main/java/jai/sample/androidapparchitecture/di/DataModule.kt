package jai.sample.androidapparchitecture.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import jai.sample.androidapparchitecture.cloud.UserWebService
import jai.sample.androidapparchitecture.data.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class DataModule(private val application: Application) {

    @Provides
    @Singleton
    fun getOnDeviceCache(): OnDeviceCache {
        return Room.databaseBuilder(application, OnDeviceCache::class.java, "demo-db").build()
    }

    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit =
            Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

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
    fun provideUserWebService(userWebService: UserWebService): WebService {
        return userWebService
    }



}