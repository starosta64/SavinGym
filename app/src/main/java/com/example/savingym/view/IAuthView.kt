package com.example.savingym.view

import com.arellomobile.mvp.MvpView

interface IAuthView : MvpView {
    fun completedAuth(answer:String)
}