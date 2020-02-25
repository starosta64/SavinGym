package com.example.savingym.ui.launch.auth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.savingym.R
import com.example.savingym.presenter.LoginPresenter
import com.example.savingym.ui.main.MainActivity
import com.example.savingym.view.ILoginView
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : MvpAppCompatFragment(), ILoginView{


    @InjectPresenter
    lateinit var presenter:LoginPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        edit_login.setOnFocusChangeListener { _, _ ->
            if(!presenter.isEmailValid(editText.text.trim()) && editText.text.isNotEmpty()){
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
        btn_sign_in.setOnClickListener {
            when(presenter.isEmailValid(editText.text) &&  presenter.isPasswordValid(editText2.text)){
                false -> Toast.makeText(context, "Incorrect username or password.", Toast.LENGTH_LONG).show()
                true -> {
                    val username = editText.text.toString()
                    val password = editText2.text.toString()
                    presenter.loginUser(username, password)
                }

            }
        }
    }

    override fun loginUser() {
        startActivity(Intent(requireContext(), MainActivity::class.java))
    }
}