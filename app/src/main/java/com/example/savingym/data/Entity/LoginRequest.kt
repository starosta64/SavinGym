package com.example.savingym.data.Entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LoginRequest(
    @SerializedName("username") val username:String? = null,
    @SerializedName("password")val password:String? = null
):Parcelable