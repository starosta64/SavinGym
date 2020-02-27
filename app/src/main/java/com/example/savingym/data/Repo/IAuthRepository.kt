package com.example.savingym.data.Repo

import com.example.savingym.data.Entity.*
import io.reactivex.Completable
import io.reactivex.Single

interface IAuthRepository {

    fun authUser(username:String, password:String, email:String, h:String, w:String): Single<AuthResponse>

    fun logoutUser(username:String): Completable

    fun loginUser(username:String, password:String):Single<LoginResponse>
}