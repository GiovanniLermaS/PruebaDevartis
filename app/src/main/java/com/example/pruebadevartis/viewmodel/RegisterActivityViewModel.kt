package com.example.pruebadevartis.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pruebadevartis.db.model.ResponseLoginRegister
import com.example.pruebadevartis.repository.RegisterActivityRepository
import javax.inject.Inject

class RegisterActivityViewModel @Inject constructor(private val registerActivityRepository: RegisterActivityRepository) :
    ViewModel() {

    private var successMainResponseLoginRegister: MutableLiveData<ResponseLoginRegister>? = MutableLiveData()
    private var errorMainRegister: MutableLiveData<String>? = MutableLiveData<String>()

    fun getSuccessMain(): LiveData<ResponseLoginRegister>? {
        return successMainResponseLoginRegister
    }

    fun setSuccessMain(team: ResponseLoginRegister?) {
        this.successMainResponseLoginRegister?.value = team
    }

    fun getErrorMain(): LiveData<String>? {
        return errorMainRegister
    }

    fun setErrorMain(message: String?) {
        this.errorMainRegister?.value = message
    }
}
