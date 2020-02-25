package com.example.savingym.data.network

import com.example.savingym.data.Entity.AuthRequest
import com.example.savingym.data.Entity.AuthResponse
import com.example.savingym.data.Entity.LoginRequest
import com.example.savingym.data.Entity.LogoutRequest
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query


interface AuthApi {

    @POST("signup")
    fun authUser(@Query("", encoded = false) username:String,
                 @Query("", encoded = false)password:String,
                 @Query("", encoded = false)email:String,
                 @Query("", encoded = false) h:String,
                 @Query("", encoded = false) w:String):Single<AuthResponse>

    @POST("signout")
    fun logoutUser(@Query("", encoded = false) logoutRequest: LogoutRequest):Completable

    @POST("signin")
    fun loginUser(@Query("", encoded = false) loginRequest: LoginRequest):Completable
}