package com.example.savingym.data.Repo

import com.example.savingym.data.Entity.Profile
import io.reactivex.Completable
import io.reactivex.Single

interface IMainRepository {

    fun getProfile(token:String): Single<List<Profile>>


    fun getLessons(): Completable//json


    fun editProfile(token:String,
                    weight:String,
                    height:String): Completable//json
}