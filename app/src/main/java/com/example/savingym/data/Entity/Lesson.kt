package com.example.savingym.data.Entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Lesson(
    @SerializedName("id") var id:String? = null,
    @SerializedName("url") var url:String? = null,
    @SerializedName("category") var category:String? = null
):Parcelable