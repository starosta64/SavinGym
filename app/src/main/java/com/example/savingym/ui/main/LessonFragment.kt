package com.example.savingym.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.savingym.R
import com.example.savingym.presenter.main.LessonPresenter
import com.example.savingym.ui.main.lesson.HandsFragment
import com.example.savingym.ui.main.lesson.LegsFragment
import com.example.savingym.ui.main.lesson.SpineFragment
import com.example.savingym.ui.main.lesson.TorsoFragment
import com.example.savingym.view.ILessonView


class LessonFragment :MvpAppCompatFragment(), ILessonView{

    private lateinit var adapter: LessonAdapter

    private lateinit var viewPager: ViewPager

    @InjectPresenter
    lateinit var presenter: LessonPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_lesson, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.getLessons()

        adapter = LessonAdapter(childFragmentManager)
        viewPager = view.findViewById(R.id.pager_lesson)
        viewPager.adapter = adapter
    }

    override fun getLessons() {

    }

    class LessonAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

        override fun getCount(): Int  = 4

        override fun getItem(i: Int): Fragment {
            var fragment:Fragment? = null
            when(i){
                0-> fragment = HandsFragment()
                1-> fragment = SpineFragment()
                2-> fragment = TorsoFragment()
                3-> fragment = LegsFragment()
            }
            fragment?.arguments = Bundle().apply {
                putInt("object", i + 1)
            }
            return fragment!!
        }

        override fun getPageTitle(position: Int): CharSequence {
            val titles: MutableList<String> = mutableListOf()
            titles.add(0, "Hands")
            titles.add(1, "Spine")
            titles.add(2, "Torso")
            titles.add(3, "Legs")
            return titles[position]
        }
    }
}