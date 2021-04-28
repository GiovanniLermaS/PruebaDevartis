package com.example.pruebadevartis.di.component

import android.app.Application
import android.content.Context
import com.example.pruebacondorlabs.di.ApplicationContext
import com.example.pruebadevartis.application.MyApplication
import com.example.pruebadevartis.di.module.ApplicationModule
import com.example.pruebadevartis.di.module.RetrofitModule
import com.example.pruebadevartis.view.main.MainActivity
import com.example.pruebadevartis.view.register.RegisterActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, RetrofitModule::class])
interface ApplicationComponent {
    fun inject(myApplication: MyApplication?)
    fun inject(mainActivity: MainActivity?)
    fun inject(registerActivity: RegisterActivity?)

    @get:ApplicationContext
    val context: Context?
    val application: Application?
}