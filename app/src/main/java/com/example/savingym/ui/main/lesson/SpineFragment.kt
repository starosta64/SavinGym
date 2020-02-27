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
import com.example.savingym.ui.main.adapter.SpineAdapter
import kotlinx.android.synthetic.main.fragment_legs.*
import kotlinx.android.synthetic.main.fragment_spine.*

class SpineFragment : MvpAppCompatFragment(){

    lateinit var adapter: SpineAdapter
    private var item:MutableList<Exercises> = mutableListOf()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_spine, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setAdapter()

        adapter = SpineAdapter(item)
        rv_spine.layoutManager = LinearLayoutManager(requireContext())

        rv_spine.adapter = adapter
    }

    private fun setAdapter(){
        item.add(Exercises(R.drawable.back, ""))
        item.add(Exercises(R.drawable.back, ""))
        item.add(Exercises(R.drawable.back, ""))
        item.add(Exercises(R.drawable.back, ""))
        item.add(Exercises(R.drawable.back, ""))
        item.add(Exercises(R.drawable.back, ""))
        item.add(Exercises(R.drawable.back, ""))
        item.add(Exercises(R.drawable.back, ""))
        item.add(Exercises(R.drawable.back, ""))
        item.add(Exercises(R.drawable.back, ""))
        item.add(Exercises(R.drawable.back, ""))
        item.add(Exercises(R.drawable.back, ""))
        item.add(Exercises(R.drawable.back, ""))
    }
}