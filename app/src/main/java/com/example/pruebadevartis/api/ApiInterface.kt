package com.example.pruebadevartis.api

import com.example.pruebadevartis.db.model.LoginRegister
import com.example.pruebadevartis.db.model.ResponseLoginRegister
import com.example.pruebadevartis.util.LOGIN
import com.example.pruebadevartis.util.REGISTER
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {

    @POST(LOGIN)
    fun loginUser(
        @Body loginRegister: LoginRegister,
    ): Single<Response<ResponseLoginRegister>>

    @POST(REGISTER)
    fun registerUser(
        @Body loginRegister: LoginRegister,
    ): Single<Response<ResponseLoginRegister>>
}