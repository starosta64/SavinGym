package com.example.savingym.data.Repo

import com.example.savingym.data.Entity.AuthRequest
import com.example.savingym.data.Entity.AuthResponse
import com.example.savingym.data.Entity.LoginRequest
import com.example.savingym.data.Entity.LogoutRequest
import io.reactivex.Completable
import io.reactivex.Single

interface IAuthRepository {

    fun authUser(username:String, password:String, email:String, h:String, w:String): Single<AuthResponse>

    fun logoutUser(username:String): Completable

    fun loginUser(username:String, password:String):Completable//json response
}