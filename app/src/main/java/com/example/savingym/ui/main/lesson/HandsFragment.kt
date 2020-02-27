package com.example.savingym.ui.main.lesson

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.MvpAppCompatFragment
import com.example.savingym.R
import com.example.savingym.data.Entity.Exercises
import com.example.savingym.ui.main.adapter.PlanAdapter
import kotlinx.android.synthetic.main.fragment_hands.*

class HandsFragment : MvpAppCompatFragment(){

    lateinit var adapter: PlanAdapter
    private var item:MutableList<Exercises> = mutableListOf()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hands, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setAdapter()

        adapter = PlanAdapter(item)
        rv_hands.layoutManager = LinearLayoutManager(requireContext())

        rv_hands.adapter = adapter
    }

    private fun setAdapter(){
        item.add(Exercises(R.drawable.hand, ""))
        item.add(Exercises(R.drawable.hand, ""))
        item.add(Exercises(R.drawable.hand, ""))
        item.add(Exercises(R.drawable.hand, ""))
        item.add(Exercises(R.drawable.hand, ""))
        item.add(Exercises(R.drawable.hand, ""))
        item.add(Exercises(R.drawable.hand, ""))
        item.add(Exercises(R.drawable.hand, ""))
        item.add(Exercises(R.drawable.hand, ""))
        item.add(Exercises(R.drawable.hand, ""))
        item.add(Exercises(R.drawable.hand, ""))
        item.add(Exercises(R.drawable.hand, ""))
        item.add(Exercises(R.drawable.hand, ""))
    }
}