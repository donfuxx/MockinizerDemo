package com.appham.mockinizer.demo

import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel : ViewModel() {

    private val demoRepository: DemoRepository =
        DemoRepository()

    fun runDemo() {


        demoRepository.getPosts()
            .subscribeOn(Schedulers.io())
            .subscribe()

        demoRepository.getMocked()
            .subscribeOn(Schedulers.io())
            .subscribe()

        demoRepository.getMockedError()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .onErrorReturn { emptyList() }
            .subscribe()
    }
}