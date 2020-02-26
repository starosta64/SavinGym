package com.example.savingym.data.Repo

import com.example.savingym.data.Entity.AuthRequest
import com.example.savingym.data.Entity.AuthResponse
import com.example.savingym.data.Entity.LoginRequest
import com.example.savingym.data.Entity.LogoutRequest
import com.example.savingym.data.network.ApiClient
import com.example.savingym.data.network.AuthApi
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class AuthRepository :IAuthRepository{

    private var service: AuthApi = ApiClient.instance.authApi

    override fun authUser(username:String, password:String, email:String, h:String, w:String): Single<AuthResponse> =
        service.authUser(username, password, email, h, w)
            .subscribeOn(Schedulers.io())

    override fun logoutUser(username:String): Completable =
        service.logoutUser(username)
            .subscribeOn(Schedulers.io())

    override fun loginUser(username:String, password:String): Completable =
        service.loginUser(username, password)
            .subscribeOn(Schedulers.io())
}