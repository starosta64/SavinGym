package com.example.savingym.view

import com.arellomobile.mvp.MvpView
import com.example.savingym.data.Entity.Lesson

interface ILessonView : MvpView {
    fun getLessons(lessons:List<Lesson>)
}