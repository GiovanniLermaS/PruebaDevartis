package com.example.pruebadevartis.application

import android.app.Application
import com.example.pruebadevartis.di.component.ApplicationComponent
import com.example.pruebadevartis.di.component.DaggerApplicationComponent
import com.example.pruebadevartis.di.module.ApplicationModule
import com.example.pruebadevartis.di.module.RetrofitModule

class MyApplication : Application() {

    var mApplicationComponent: ApplicationComponent? = null

    override fun onCreate() {
        super.onCreate()
        mApplicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .retrofitModule(RetrofitModule(this))
            .build()
        mApplicationComponent?.inject(this)
    }

    fun getComponent(): ApplicationComponent? {
        return mApplicationComponent
    }
}