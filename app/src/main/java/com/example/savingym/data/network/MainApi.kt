package com.example.savingym.data.network

import com.example.savingym.data.Entity.Profile
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

interface MainApi {
    @POST("/profile")
    fun getProfile(
        @Query("token") token: String
    ): Single<List<Profile>>

    @GET("/lessons")
    fun getLessons(): Completable//json

    @PUT("/editeprofile")
    fun editProfile(
        @Query("token") token: String,
        @Query("weight") weight: String,
        @Query("height") height: String
    ): Completable//json
}