package com.example.savingym.view

import com.arellomobile.mvp.MvpView
import com.example.savingym.data.Entity.Profile

interface IMainView :MvpView{
    fun logout()
    fun getProfile(profile:List<Profile>)
    fun editProfile()
}