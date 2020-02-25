package com.example.savingym.view

import com.arellomobile.mvp.MvpView
import com.example.savingym.data.Entity.AuthRequest

interface ILoginView : MvpView {
    fun loginUser()
}