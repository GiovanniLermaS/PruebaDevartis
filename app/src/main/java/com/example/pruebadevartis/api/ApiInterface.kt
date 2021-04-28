package com.example.pruebadevartis.api

import com.example.pruebadevartis.db.model.Register
import com.example.pruebadevartis.util.LEAGUE
import com.example.pruebadevartis.util.REGISTER
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiInterface {

    @POST(REGISTER)
    fun registerUser(
        @Query(LEAGUE) league: String
    ): Single<Response<Register>>
}