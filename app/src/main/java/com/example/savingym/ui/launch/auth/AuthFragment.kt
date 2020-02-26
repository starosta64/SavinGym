package com.example.savingym.ui.launch.auth

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.savingym.R
import com.example.savingym.presenter.AuthPresenter
import com.example.savingym.view.IAuthView
import kotlinx.android.synthetic.main.fragment_auth.*

class AuthFragment :MvpAppCompatFragment(), IAuthView {

    companion object {
        private const val USER_WEIGHT = "user_weight"
        private const val USER_HEIGHT = "user_height"
        private const val APP_PREFERENCES = "mysettings"
    }

    @InjectPresenter
    lateinit var presenter: AuthPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_auth, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_back.setOnClickListener {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, LoginFragment())
                .commit()
        }
        edit_login.setOnFocusChangeListener { _, _ ->
            if(presenter.isUserValid(editText.text.trim())){
                editText.error = "Incorrent username!"
            }
        }
        edit_email.setOnFocusChangeListener { _, _ ->
            if(!presenter.isEmailValid(et_email.text.trim()) && et_email.text.isNotEmpty()){
                editText.error = "Incorrent email!"
            }
        }
        edit_password.setOnFocusChangeListener { _, _ ->
            if(!presenter.isPasswordValid(editText2.text) && editText2.text.isNotEmpty()){
                editText2.error = "Incorrect password!"
            }
        }
        btn_sign_up.setOnClickListener {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, AuthFragment())
                .commit()
        }
        btn_sign_up.setOnClickListener {
            val pref = this.requireActivity().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)
            val w: String? = pref.getString(USER_WEIGHT, "78")
            val h: String? = pref.getString(USER_HEIGHT, "178")
            when(presenter.isUserValid(editText.text) &&presenter.isEmailValid(et_email.text) &&  presenter.isPasswordValid(editText2.text)
                    && presenter.isPasswordEquals(editText2.text, editText3.text)){
                false -> Toast.makeText(context, "Incorrect username or password.", Toast.LENGTH_LONG).show()
                true -> {
                    val username = editText.text.toString()
                    val email = et_email.text.toString()
                    val password = editText2.text.toString()
                    presenter.authUser(username,email, password, h!!, w!!)
                }

            }
        }

    }

    override fun completedAuth(answer: String) {
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, LoginFragment())
            .commit()
        //Toast.makeText(requireContext(), answer, Toast.LENGTH_LONG ).show()
    }
}