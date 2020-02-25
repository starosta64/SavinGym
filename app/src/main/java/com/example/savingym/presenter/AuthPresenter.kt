package com.example.savingym.presenter

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.savingym.data.Entity.AuthRequest
import com.example.savingym.data.Repo.AuthRepository
import com.example.savingym.view.IAuthView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

@InjectViewState
class AuthPresenter : MvpPresenter<IAuthView>() {

    val compose:CompositeDisposable = CompositeDisposable()

    private var authRepository: AuthRepository = AuthRepository()


    fun isUserValid(username: CharSequence): Boolean =
        username.isNotEmpty()

    fun isEmailValid(email: CharSequence): Boolean =
        android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()


    fun isPasswordValid(password: CharSequence): Boolean {
        val regex = Regex("""^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\S+${'$'}).{8,}""")
        return regex.matches(password)
    }

    fun isPasswordEquals(password: CharSequence, password2: CharSequence): Boolean {
        return password.length == password2.length && password.contains(password2)
    }

    fun authUser(username: String, email: String, password: String, h: String, w: String) {

        val authRequest = AuthRequest(username, password, email, h, w)
        compose.add(authRepository.authUser(username, password, email, h, w)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.completedAuth(it.answer.toString())
            }, {
                Log.e("Auth", it.localizedMessage)
            })
        )
    }

}