package com.appham.mockinizer.demo

import com.appham.mockinizer.RequestFilter
import okhttp3.mockwebserver.MockResponse

val mocks: Map<RequestFilter, MockResponse> = mapOf(

    RequestFilter("/mocked") to MockResponse().apply {
        setResponseCode(200)
        setBody("""{"title": "Banana Mock"}""")
    },

    RequestFilter("/mockedError") to MockResponse().apply {
        setResponseCode(400)
    }

)