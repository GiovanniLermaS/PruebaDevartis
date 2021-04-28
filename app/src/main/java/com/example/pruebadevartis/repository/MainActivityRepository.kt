package com.example.pruebadevartis.repository

import com.example.pruebadevartis.api.ApiInterface
import com.example.pruebadevartis.db.model.Register
import io.reactivex.Single
import retrofit2.Response
import javax.inject.Inject

class MainActivityRepository @Inject constructor(private val apiInterface: ApiInterface) {

    fun registerUser(league: String): Single<Response<Register>> {
        return apiInterface.registerUser(league)
    }
}