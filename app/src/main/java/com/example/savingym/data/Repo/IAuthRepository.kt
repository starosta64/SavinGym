package com.example.savingym.data.Repo

import com.example.savingym.data.Entity.AuthRequest
import com.example.savingym.data.Entity.AuthResponse
import com.example.savingym.data.Entity.LoginRequest
import com.example.savingym.data.Entity.LogoutRequest
import io.reactivex.Completable
import io.reactivex.Single

interface IAuthRepository {

    fun authUser(username:String, password:String, email:String, h:String, w:String): Single<AuthResponse>

    fun logoutUser(logoutRequest: LogoutRequest): Completable

    fun loginUser(loginRequest:LoginRequest):Completable//json response
}