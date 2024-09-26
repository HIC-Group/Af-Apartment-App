package com.afapartment

import android.app.Application
import com.afapartment.di.dataSourceModule
import com.afapartment.di.databaseModule
import com.afapartment.di.networkModule
import com.afapartment.di.repositoryModule
import com.afapartment.di.useCaseModule
import com.afapartment.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@App)
            modules(
                networkModule,
                databaseModule,
                dataSourceModule,
                repositoryModule,
                useCaseModule,
                viewModelModule
            )
        }
    }
}