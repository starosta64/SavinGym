package com.example.savingym.ui.launch.splash

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.savingym.R
import com.example.savingym.R.drawable.step_y
import kotlinx.android.synthetic.main.fragment_first_step.*

class FirstStepFragment : Fragment(){

    companion object {
        private const val TRANSACTION_FRAGMENT: Long =800
    }
        override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first_step, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button5.setOnClickListener {
            button5.background = resources.getDrawable(step_y)
            Handler().postDelayed({
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.container,
                        SecondStepFragment()
                    )
                    .addToBackStack(null)
                    .commit()
            },
                TRANSACTION_FRAGMENT
            )

        }
        button4.setOnClickListener {
            button5.background = resources.getDrawable(step_y)
            Handler().postDelayed({
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.container,
                        SecondStepFragment()
                    )
                    .addToBackStack(null)
                    .commit()
            },
                TRANSACTION_FRAGMENT
            )

        }
        button6.setOnClickListener {
            button5.background = resources.getDrawable(step_y)
            Handler().postDelayed({
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.container,
                        SecondStepFragment()
                    )
                    .addToBackStack(null)
                    .commit()
            },
                TRANSACTION_FRAGMENT
            )

        }
    }
}