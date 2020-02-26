package com.example.savingym.data.Entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AuthResponse(
    @SerializedName("answer")val answer:String? = null
) : Parcelable