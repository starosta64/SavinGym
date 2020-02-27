package com.example.savingym.ui.main

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.MvpAppCompatFragment
import com.example.savingym.R
import com.example.savingym.data.Entity.Exercises
import com.example.savingym.ui.main.adapter.PlanAdapter
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : MvpAppCompatFragment() {

    companion object {
        private const val USER_NAME = "user_name"
        private const val APP_PREFERENCES = "mysettings"
    }

    private var pref: SharedPreferences? = null


    lateinit var adapter: PlanAdapter

    private var item: MutableList<Exercises> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setAdapter()

        adapter = PlanAdapter(item)
        rv_main.layoutManager = LinearLayoutManager(requireContext())

        rv_main.adapter = adapter

        pref = requireActivity().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)

    }

    private fun setAdapter() {
        item.add(Exercises(R.drawable.hand, "Hands"))
        item.add(Exercises(R.drawable.back, "Spine"))
        item.add(Exercises(R.drawable.forward, "Torso"))
        item.add(Exercises(R.drawable.legs, "Legs"))
    }


}