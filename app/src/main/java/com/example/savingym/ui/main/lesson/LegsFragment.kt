package com.example.savingym.ui.main.lesson

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.MvpAppCompatFragment
import com.example.savingym.R
import com.example.savingym.data.Entity.Exercises
import com.example.savingym.ui.main.adapter.LegsAdapter
import kotlinx.android.synthetic.main.fragment_legs.*

class LegsFragment : MvpAppCompatFragment(){

    lateinit var adapter: LegsAdapter
    private var item:MutableList<Exercises> = mutableListOf()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_legs, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setAdapter()

        adapter = LegsAdapter(item)
        rv_legs.layoutManager = LinearLayoutManager(requireContext())

        rv_legs.adapter = adapter
    }

    private fun setAdapter(){
        item.add(Exercises(R.drawable.legs, ""))
        item.add(Exercises(R.drawable.legs, ""))
        item.add(Exercises(R.drawable.legs, ""))
        item.add(Exercises(R.drawable.legs, ""))
        item.add(Exercises(R.drawable.legs, ""))
        item.add(Exercises(R.drawable.legs, ""))
        item.add(Exercises(R.drawable.legs, ""))
        item.add(Exercises(R.drawable.legs, ""))
        item.add(Exercises(R.drawable.legs, ""))
        item.add(Exercises(R.drawable.legs, ""))
        item.add(Exercises(R.drawable.legs, ""))
        item.add(Exercises(R.drawable.legs, ""))
        item.add(Exercises(R.drawable.legs, ""))
    }
}