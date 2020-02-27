package com.example.savingym.presenter.main

import android.content.SharedPreferences
import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.savingym.data.Repo.AuthRepository
import com.example.savingym.data.Repo.MainRepository
import com.example.savingym.view.IMainView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

@InjectViewState
class MainPresenter : MvpPresenter<IMainView>(){

    private var authRepository: AuthRepository = AuthRepository()
    private var mainRepository: MainRepository = MainRepository()

    private val compose: CompositeDisposable = CompositeDisposable()

    fun editProfile(token:String, w:String,h:String){
        compose.add(
            mainRepository.editProfile(token, w, h)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    viewState.editProfile()
                },{
                    Log.e("Main", it.localizedMessage)
                })

        )
    }

    fun getProfile(token:String){
        compose.add(
            mainRepository.getProfile(token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    viewState.getProfile(it)
                },{
                    Log.e("Main", it.localizedMessage)
                })
        )
    }

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

    override fun onDestroy() {
        super.onDestroy()
        compose.dispose()
    }
}
