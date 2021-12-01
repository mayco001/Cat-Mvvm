package com.mayco.catmvvm

import android.app.Application
import android.content.Context
import com.mayco.catmvvm.di.applicationModulo
import com.mayco.catmvvm.di.repositoryModule
import com.mayco.catmvvm.di.viewModelModule
import com.orhanobut.hawk.Hawk
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class CatAplication : Application() {
    override fun onCreate() {
        super.onCreate()

        instace = applicationContext

        setupKoin()
        setupHawk()
    }

    private fun setupKoin() {
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@CatAplication)
            androidFileProperties()
            modules(applicationModulo, repositoryModule,viewModelModule)
        }
    }

    private fun setupHawk() = Hawk.init(this).build()


    companion object {
        lateinit var instace: Context
    }
}