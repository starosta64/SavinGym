package com.example.savingym.ui.main

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.checkbox.checkBoxPrompt
import com.afollestad.materialdialogs.customview.customView
import com.afollestad.materialdialogs.customview.getCustomView
import com.afollestad.materialdialogs.input.input
import com.afollestad.materialdialogs.list.checkItems
import com.afollestad.materialdialogs.list.listItems
import com.afollestad.materialdialogs.list.listItemsSingleChoice
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

        val editor = pref?.edit()
        policy.setOnClickListener {
            startActivity(Intent(requireActivity(), WebAcrivity::class.java))
        }
        bio.setOnClickListener {

            MaterialDialog(requireContext()).show{
                title(R.string.bio)
                message(R.string.message)
                customView(R.layout.custom_dialog)
                positiveButton(R.string.positive){
                    val weightInput: EditText = it.getCustomView()
                        .findViewById(R.id.weight_dialog)
                    val heightInput: EditText = it.getCustomView()
                        .findViewById(R.id.height_dialog)
                    presenter.editProfile(token!!,weightInput.text.toString() ,heightInput.text.toString())
                }
                negativeButton(R.string.negative)
            }
        }
        start_dialog.setOnClickListener {
            MaterialDialog(requireContext()).show{
                title(R.string.gen)
                message(R.string.message_gen)
                listItemsSingleChoice(R.array.gender, initialSelection = 1) { dialog, index, text ->
                    when(index){
                        0->{
                            editor?.putString(USER_GENDER, text.toString())
                            editor?.apply()
                        }
                        1->{
                            editor?.putString(USER_GENDER, text.toString())
                            editor?.apply()
                        }
                    }
                }
                positiveButton(R.string.positive){

                }
                negativeButton(R.string.negative)
            }
        }

        btn_logout.setOnClickListener {
            username?.let { name -> presenter.logoutUser(name) }
        }
    }

    override fun getProfile(profile:List<Profile>) {
        name.text = profile[0].username
        size_w.text = profile[0].weight
        size_h.text = profile[0].height
        gender.text = pref?.getString(USER_GENDER, "male")
    }

    override fun editProfile() {
    }

    override fun logout() {
        activity?.finish()
    }
}