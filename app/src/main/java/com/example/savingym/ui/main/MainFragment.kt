package com.example.savingym.ui.main

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.savingym.R
import com.example.savingym.presenter.main.MainPresenter
import com.example.savingym.view.IMainView
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment :MvpAppCompatFragment(), IMainView {

    companion object {
        private const val USER_NAME = "user_name"
        private const val APP_PREFERENCES = "mysettings"
    }

    private var pref :SharedPreferences? = null

    @InjectPresenter
    lateinit var presenter: MainPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pref = requireActivity().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)

        btn_back.setOnClickListener {
            val username = pref?.getString(USER_NAME, "")
            presenter.logoutUser(username?:"")
        }
    }

    override fun logout() {
        activity?.finish()
    }
}