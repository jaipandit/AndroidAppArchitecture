package jai.sample.androidapparchitecture.di

import dagger.Component
import jai.sample.androidapparchitecture.ui.UserDetailFragment
import jai.sample.androidapparchitecture.ui.UserListFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, DataModule::class, ViewModelModule::class])
interface AppComponent {

    fun inject(userDetailFragment: UserDetailFragment)
    fun inject(userListFragment: UserListFragment)
}