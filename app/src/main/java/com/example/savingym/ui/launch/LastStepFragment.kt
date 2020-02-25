package com.example.savingym.ui.launch

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.savingym.R
import kotlinx.android.synthetic.main.fragment_last_step.*

class LastStepFragment : Fragment() {
    companion object {
        private const val TRANSACTION_FRAGMENT: Long = 800
        private const val USER_WEIGHT = "user_weight"
        private const val USER_HEIGHT = "user_height"
        private const val APP_PREFERENCES = "mysettings"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_last_step, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pref = this.requireActivity().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)
        val editor = pref.edit()


        button4.setOnClickListener {
            val w: String? = pref.getString(USER_WEIGHT, et_weight.text.toString())
            val h: String? = pref.getString(USER_HEIGHT, et_height.text.toString())
            editor.apply()

            button4.setOnClickListener {
                button4.background = resources.getDrawable(R.drawable.step_y)
                Handler().postDelayed({
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.container, LoginFragment())
                        .addToBackStack(null)
                        .commit()
                }, TRANSACTION_FRAGMENT)
            }
        }
    }
}