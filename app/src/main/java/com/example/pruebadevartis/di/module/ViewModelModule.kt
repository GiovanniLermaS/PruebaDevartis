package com.example.pruebadevartis.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pruebadevartis.di.util.ViewModelKey
import com.example.pruebadevartis.util.ViewModelFactory
import com.example.pruebadevartis.viewmodel.MainActivityViewModel
import com.example.pruebadevartis.viewmodel.RegisterActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun bindMainActivityViewModel(mainActivityViewModel: MainActivityViewModel?): ViewModel?

    @Binds
    @IntoMap
    @ViewModelKey(RegisterActivityViewModel::class)
    abstract fun bindRegisterActivityViewModel(registerActivityViewModel: RegisterActivityViewModel?): ViewModel?

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory?): ViewModelProvider.Factory?
}