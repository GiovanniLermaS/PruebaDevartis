package com.example.pruebadevartis.repository

import com.example.pruebadevartis.api.ApiInterface
import com.example.pruebadevartis.db.model.LoginRegister
import com.example.pruebadevartis.db.model.ResponseLoginRegister
import io.reactivex.Single
import retrofit2.Response
import javax.inject.Inject

class MainActivityRepository @Inject constructor(private val apiInterface: ApiInterface) {

    fun loginRegisterUser(
        loginRegister: LoginRegister,
        isLogin: Boolean
    ): Single<Response<ResponseLoginRegister>> {
        return if (isLogin) apiInterface.loginUser(loginRegister)
        else apiInterface.registerUser(loginRegister)
    }
}