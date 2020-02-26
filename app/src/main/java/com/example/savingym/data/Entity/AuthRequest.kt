package com.example.savingym.data.Entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AuthRequest(
    @SerializedName("username")val username:String? = null,
    @SerializedName("password")val password:String? = null,
    @SerializedName("email")val email:String? = null,
    @SerializedName("weight")val weight:String? = null,
    @SerializedName("height")val height:String? = null
) : Parcelable