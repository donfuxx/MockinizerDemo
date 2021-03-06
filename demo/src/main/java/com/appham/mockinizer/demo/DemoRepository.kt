package com.appham.mockinizer.demo

import io.reactivex.Single

class DemoRepository(
    private val apiService: ApiService = RealApi()
) {

    fun getPosts(): Single<List<Post>> {
        return apiService.demoApi.getPosts()
    }

    fun getMocked(): Single<List<Post>> {
        return apiService.demoApi.getMocked()
    }

    fun getMockedError(): Single<List<Post>> {
        return apiService.demoApi.getMockedError()
    }

}