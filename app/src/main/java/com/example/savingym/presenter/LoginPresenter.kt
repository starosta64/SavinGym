package com.example.savingym.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter

import com.example.savingym.data.Entity.LoginRequest
import com.example.savingym.data.Repo.AuthRepository
import com.example.savingym.view.ILoginView
import io.reactivex.android.schedulers.AndroidSchedulers



@InjectViewState
class LoginPresenter :MvpPresenter<ILoginView>(){
    private var authRepository:AuthRepository = AuthRepository()

    fun isEmailValid(email:CharSequence):Boolean =
        android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()


    fun isPasswordValid(password:CharSequence):Boolean {
        val regex = Regex("""^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\S+${'$'}).{8,}""")
        return regex.matches(password)
    }

    fun loginUser(username:String, password: String){
        val loginRequest = LoginRequest(username, password)
        authRepository.loginUser(loginRequest)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.loginUser()
            },{

            }).dispose()
    }
}