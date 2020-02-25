package com.example.savingym.ui.launch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.savingym.R
import kotlinx.android.synthetic.main.fragment_second_step.*

class SecondStepFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second_step, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        next_btn.setOnClickListener {
            next_btn.background = resources.getDrawable(R.drawable.step_y)
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, ThirdStepFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}