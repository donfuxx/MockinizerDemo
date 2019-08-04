package com.appham.mockinizer.demo

import io.reactivex.Single

class DemoRepository {

    private val apiService: ApiService =
        ApiService()

    fun getPosts(): Single<List<Post>> {
        return apiService.demoApi.getPosts()
    }

    fun getMocked(): Single<List<Post>> {
        return apiService.demoApi.getMocked()
    }

}