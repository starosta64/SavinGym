package com.example.savingym.ui.launch

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.savingym.R
import kotlinx.android.synthetic.main.fragment_second_step.*
import kotlinx.android.synthetic.main.fragment_third_step.*

class ThirdStepFragment : Fragment() {

    companion object {
        private const val TRANSACTION_FRAGMENT: Long = 800
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_third_step, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        button.setOnClickListener {
            button.background = resources.getDrawable(R.drawable.step_y)
            Handler().postDelayed({
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.container, FourthStepFragment())
                    .addToBackStack(null)
                    .commit()
            }, TRANSACTION_FRAGMENT)
        }

        button3.setOnClickListener {
            button3.background = resources.getDrawable(R.drawable.step_y)
            Handler().postDelayed({
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.container, FourthStepFragment())
                    .addToBackStack(null)
                    .commit()
            }, TRANSACTION_FRAGMENT)
        }

        button2.setOnClickListener {
            button2.background = resources.getDrawable(R.drawable.step_y)
            Handler().postDelayed({
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.container, FourthStepFragment())
                    .addToBackStack(null)
                    .commit()
            }, TRANSACTION_FRAGMENT)
        }

        button7.setOnClickListener {
            button7.background = resources.getDrawable(R.drawable.step_y)
            Handler().postDelayed({
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.container, FourthStepFragment())
                    .addToBackStack(null)
                    .commit()
            }, TRANSACTION_FRAGMENT)
        }
    }
}