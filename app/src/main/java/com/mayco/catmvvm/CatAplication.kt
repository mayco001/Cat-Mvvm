package com.mayco.catmvvm

import android.app.Application
import android.content.Context
import com.orhanobut.hawk.Hawk
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CatAplication : Application() {
    override fun onCreate() {
        super.onCreate()

        instace = applicationContext

//        setupKoin()
        setupHawk()
    }

//    private fun setupKoin() {
//        startKoin {
//            androidLogger(Level.ERROR)
//            androidContext(this@CatAplication)
//            androidFileProperties()
//            modules(applicationModulo, repositoryModule, viewModelModule)
//        }
//    }

    private fun setupHawk() = Hawk.init(this).build()

    companion object {
        lateinit var instace: Context
    }
}
