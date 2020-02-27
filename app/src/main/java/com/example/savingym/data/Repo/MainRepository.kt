package com.example.savingym.data.Repo

import com.example.savingym.data.Entity.Lesson
import com.example.savingym.data.Entity.Profile
import com.example.savingym.data.network.ApiClient
import com.example.savingym.data.network.MainApi
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class MainRepository :IMainRepository{
    private var service: MainApi = ApiClient.instance.mainApi

    override fun getProfile(token: String): Single<List<Profile>> {
        return service.getProfile(token)
            .subscribeOn(Schedulers.io())
    }

    override fun getLessons(): Single<List<Lesson>> {
        return service.getLessons()
            .subscribeOn(Schedulers.io())

    }

    override fun editProfile(token: String, weight: String, height: String): Completable {
        return service.editProfile(token, weight, height)
            .subscribeOn(Schedulers.io())

    }
}