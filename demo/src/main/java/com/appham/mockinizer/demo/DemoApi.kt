package com.appham.mockinizer.demo

import io.reactivex.Single
import retrofit2.http.GET

/**
 * This Api defines how to get demo data
 */
interface DemoApi {

    @GET("typicode/demo/posts")
    fun getPosts(): Single<List<Post>>

    @GET("mocked")
    fun getMocked(): Single<Post>

    @GET("mockedError")
    fun getMockedError(): Single<List<Post>>

}
