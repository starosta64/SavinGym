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
import com.example.savingym.data.Entity.Profile
import com.example.savingym.presenter.main.MainPresenter
import com.example.savingym.view.IMainView
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : MvpAppCompatFragment(), IMainView {


    companion object {
        private const val TOKEN = "token"
        private const val USER_NAME = "user_name"
        private const val USER_GENDER = "user_gender"
        private const val APP_PREFERENCES = "mysettings"
    }

    private var pref: SharedPreferences? = null

    @InjectPresenter
    lateinit var presenter: MainPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pref = requireActivity().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)
        val username = pref?.getString(USER_NAME, "")
        val token = pref?.getString(TOKEN, "")

        presenter.getProfile(token ?: "")

        btn_logout.setOnClickListener {
            username?.let { name -> presenter.logoutUser(name) }
        }
    }

    override fun getProfile(profile:List<Profile>) {
        name.text = profile[0].username
        size_w.text = profile[0].weight
        size_w.text = profile[0].height
        gender.text = pref?.getString(USER_GENDER, "male")
    }

    override fun editProfile() {
    }

    override fun logout() {
        activity?.finish()
    }
}