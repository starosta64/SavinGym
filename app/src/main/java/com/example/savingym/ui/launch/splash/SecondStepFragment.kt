package com.example.savingym.ui.launch.splash

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.savingym.R
import kotlinx.android.synthetic.main.fragment_second_step.*

class SecondStepFragment : Fragment() {

    companion object{
        private const val TRANSACTION_FRAGMENT: Long = 800
        private const val USER_GENDER = "user_gender"
        private const val APP_PREFERENCES = "mysettings"
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second_step, container, false)
    }
    private var isFemale= false
    private var isMale = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val gender = this.requireActivity().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)
        val editor = gender.edit()
        Female.setOnClickListener {
            isFemale = !isFemale
            if(isFemale){
                Female.background = resources.getDrawable(R.drawable.step_y)
                Male.background = resources.getDrawable(R.drawable.step)
                editor.putString(USER_GENDER, "female")
                editor.apply()
                isMale = false
            }
            else {
                isFemale = false
                Female.background = resources.getDrawable(R.drawable.step)
            }

        }
        Male.setOnClickListener {
            isMale = !isMale
            if(isFemale){
                Female.background = resources.getDrawable(R.drawable.step)
                Male.background = resources.getDrawable(R.drawable.step_y)
                editor.remove(USER_GENDER)
                editor.apply()
                isFemale = false
            }
            else{
                isFemale = false
                Male.background = resources.getDrawable(R.drawable.step)
            }
        }



            next_btn.setOnClickListener {
                next_btn.background = resources.getDrawable(R.drawable.step_y)
                Handler().postDelayed({
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.container,
                            ThirdStepFragment()
                        )
                        .addToBackStack(null)
                        .commit()
                },
                    TRANSACTION_FRAGMENT
                )
            }
    }
}