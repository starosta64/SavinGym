package com.example.savingym.data.network

import io.reactivex.Completable
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

interface MainApi {
    @POST("/profile")
    fun getProfile(@Query("token") token:String
                 ): Completable//json

    @POST("/signout")
    fun logoutUser(@Query("username") username:String): Completable

    @GET("/lessons")
    fun getLessons(): Completable//json

    @PUT("/editeprofile")
    fun editProfile(@Query("token") token:String,
        @Query("weight") weight:String,
                  @Query("height")height:String): Completable//json
}