package com.example.savingym.presenter

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter

import com.example.savingym.data.Entity.LoginRequest
import com.example.savingym.data.Repo.AuthRepository
import com.example.savingym.view.ILoginView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable


@InjectViewState
class LoginPresenter :MvpPresenter<ILoginView>(){
    private var authRepository:AuthRepository = AuthRepository()

    private val compose: CompositeDisposable = CompositeDisposable()

    fun isUserValid(username: CharSequence): Boolean =
        username.isNotEmpty()

    fun isPasswordValid(password:CharSequence):Boolean {
        val regex = Regex("""^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\S+${'$'}).{8,}""")
        return regex.matches(password)
    }

    fun loginUser(username:String, password: String){
        compose.add(authRepository.loginUser(username, password)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if(it.notice?.token!= null){
                    viewState.loginUser(it.notice?.token!!)
                }
                else {
                    viewState.activeUser()
                }
            },{
                Log.e("Auth", it.localizedMessage)
            }))
    }

    override fun onDestroy() {
        super.onDestroy()
        compose.dispose()
    }
}