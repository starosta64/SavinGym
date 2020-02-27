package com.example.savingym.presenter.main

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.savingym.data.Repo.MainRepository
import com.example.savingym.view.ILessonView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable


@InjectViewState
class LessonPresenter : MvpPresenter<ILessonView>(){

    private var mainRepository: MainRepository = MainRepository()

    private val compose: CompositeDisposable = CompositeDisposable()

    fun getLessons(){
        compose.add(
            mainRepository.getLessons()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    viewState.getLessons()
                },{
                    Log.e("Main", it.localizedMessage)
                })
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        compose.dispose()
    }
}