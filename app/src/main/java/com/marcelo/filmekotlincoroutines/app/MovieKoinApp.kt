package com.marcelo.filmekotlincoroutines.app

import android.app.Application
import com.marcelo.filmekotlincoroutines.directory.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MovieKoinApp: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MovieKoinApp)

            modules(listOf(
                viewModelModule
            ))
        }
    }
}