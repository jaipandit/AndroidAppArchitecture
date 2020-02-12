package jai.sample.androidapparchitecture.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import jai.sample.androidapparchitecture.cloud.RetrofitWebService
import jai.sample.androidapparchitecture.data.OnDeviceCache
import jai.sample.androidapparchitecture.data.WebService

@Module
class AppModule(private val application: Application) {

    @Provides
    fun provideContext(): Context = application

    @Provides
    fun provideWebService(userProfileWebService: RetrofitWebService): WebService = userProfileWebService

    @Provides
    fun provideDatabase(): OnDeviceCache {
        TODO()
    }
}