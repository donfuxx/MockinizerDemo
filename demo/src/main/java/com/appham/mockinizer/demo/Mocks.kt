package com.appham.mockinizer.demo

import com.appham.mockinizer.RequestFilter
import okhttp3.mockwebserver.MockResponse
import java.util.concurrent.TimeUnit

val mocks: Map<RequestFilter, MockResponse> = mapOf(

    RequestFilter("/typicode/demo/mocked") to MockResponse().apply {
        setResponseCode(200)
        setBody(
            """
                        [
                          {
                            "id": 555,
                            "title": "Banana Mock"
                          },
                          {
                            "id": 675,
                            "title": "foooo"
                          }
                        ]
                    """.trimIndent()
        )
        setBodyDelay(1, TimeUnit.SECONDS)
        setHeadersDelay(1, TimeUnit.SECONDS)
    },

    RequestFilter("/typicode/demo/mockedError") to MockResponse().apply {
        setResponseCode(400)
        setHeadersDelay(2, TimeUnit.SECONDS)
        setBodyDelay(2, TimeUnit.SECONDS)
    }

)