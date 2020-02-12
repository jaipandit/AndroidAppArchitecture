package jai.sample.androidapparchitecture

import android.app.Application
import jai.sample.androidapparchitecture.di.AppComponent
import jai.sample.androidapparchitecture.di.AppModule
import jai.sample.androidapparchitecture.di.DaggerAppComponent

class SampleApplication : Application() {

    private val component: AppComponent by lazy {
        DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()
    }

    fun getDependencyInjector() = component
}