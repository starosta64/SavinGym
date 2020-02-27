package com.example.savingym.data.Entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Profile(
    @SerializedName("id") var id:String? = null,
    @SerializedName("username") var username:String? = null,
    @SerializedName("email") var email:String? = null,
    @SerializedName("password") var password:String? = null,
    @SerializedName("weight") var weight:String? = null,
    @SerializedName("height") var height:String? = null
) : Parcelable