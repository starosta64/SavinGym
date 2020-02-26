package com.example.savingym.ui.launch.splash

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.savingym.R
import kotlinx.android.synthetic.main.fragment_fourth_step.*

class FourthStepFragment : Fragment(){

    companion object {
        private const val TRANSACTION_FRAGMENT: Long = 800
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_fourth_step, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button5.setOnClickListener {
            button5.background = resources.getDrawable(R.drawable.step_y)
            Handler().postDelayed({
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.container,
                        LastStepFragment()
                    )
                    .addToBackStack(null)
                    .commit()
            },
                TRANSACTION_FRAGMENT
            )
        }

        button4.setOnClickListener {
            button4.background = resources.getDrawable(R.drawable.step_y)
            Handler().postDelayed({
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.container,
                        LastStepFragment()
                    )
                    .addToBackStack(null)
                    .commit()
            },
                TRANSACTION_FRAGMENT
            )
        }

        button6.setOnClickListener {
            button6.background = resources.getDrawable(R.drawable.step_y)
            Handler().postDelayed({
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.container,
                        LastStepFragment()
                    )
                    .addToBackStack(null)
                    .commit()
            },
                TRANSACTION_FRAGMENT
            )
        }
    }
}