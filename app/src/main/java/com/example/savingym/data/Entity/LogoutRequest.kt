package com.example.savingym.data.Entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LogoutRequest(
    @SerializedName("username") val username:String? = null
): Parcelable