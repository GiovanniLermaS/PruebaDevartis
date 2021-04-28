package com.example.pruebadevartis.repository

import com.example.pruebadevartis.api.ApiInterface
import com.example.pruebadevartis.db.model.LoginRegister
import com.example.pruebadevartis.db.model.ResponseLoginRegister
import io.reactivex.Single
import retrofit2.Response
import javax.inject.Inject

class RegisterActivityRepository @Inject constructor(private val apiInterface: ApiInterface) {

    fun registerUser(loginRegister: LoginRegister): Single<Response<ResponseLoginRegister>> {
        return apiInterface.registerUser(loginRegister)
    }
}