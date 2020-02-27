package com.example.savingym.data.Entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Token(
    @SerializedName("token") var token:String? = null,
    @SerializedName("answer") var answer:String? = null
):Parcelable