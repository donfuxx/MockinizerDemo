package com.appham.mockinizer.demo

import androidx.lifecycle.ViewModel
import io.reactivex.schedulers.Schedulers

class MainViewModel : ViewModel() {

    private val demoRepository: DemoRepository =
        DemoRepository()

    fun runDemo() {

        demoRepository.getMocked()
            .subscribeOn(Schedulers.io())
            .subscribe()

        demoRepository.getPosts()
            .subscribeOn(Schedulers.io())
            .subscribe()

    }
}