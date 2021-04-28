package com.example.pruebadevartis.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Register(
    @PrimaryKey @SerializedName("user_id") var userId: Int,
    @SerializedName("access_token") var accessToken: String? = null,
)