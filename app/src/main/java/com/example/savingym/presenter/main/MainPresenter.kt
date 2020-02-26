package com.example.savingym.presenter.main

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.savingym.data.Repo.AuthRepository
import com.example.savingym.view.IMainView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

@InjectViewState
class MainPresenter : MvpPresenter<IMainView>(){

    private var authRepository: AuthRepository = AuthRepository()

    private val compose: CompositeDisposable = CompositeDisposable()

    fun logoutUser(username: String){
        compose.add(
            authRepository.logoutUser(username)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    viewState.logout()
                },{
                    Log.e("Main", it.localizedMessage)
                })
        )
    }
}
