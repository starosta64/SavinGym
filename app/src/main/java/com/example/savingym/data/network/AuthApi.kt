package com.example.savingym.data.network

import com.example.savingym.data.Entity.*
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query


interface AuthApi {

    @POST("/signup")
    fun authUser(@Query("username") username:String,
                 @Query("password")password:String,
                 @Query("email")email:String,
                 @Query("height") h:String,
                 @Query("weight") w:String):Single<AuthResponse>

    @POST("/signout")
    fun logoutUser(@Query("username") username:String):Completable

    @POST("/signin")
    fun loginUser(@Query("username") username:String,
                  @Query("password")password:String):Single<LoginResponse>
}