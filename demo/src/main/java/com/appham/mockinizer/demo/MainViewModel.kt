package com.appham.mockinizer.demo

import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class MainViewModel(
    private val demoRepository: DemoRepository = DemoRepository()
) : ViewModel() {

    fun runDemo() {

        demoRepository.getMocked()
            .subscribeOn(Schedulers.io())
            .delay(1, TimeUnit.SECONDS)
            .subscribe()

        demoRepository.getMockedError()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .onErrorReturn { emptyList() }
            .delay(2, TimeUnit.SECONDS)
            .subscribe()

        demoRepository.getPosts()
            .subscribeOn(Schedulers.io())
            .subscribe()

    }
}