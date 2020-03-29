package com.appham.mockinizer.demo

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.appham.mockinizer.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val activityRule by lazy {
        ActivityTestRule<MainActivity>(MainActivity::class.java)
    }

    @Test
    fun testCheckLogcatDisplayed() {
        onView(withId(R.id.txt_check_log)).check(matches(isDisplayed()))
    }

}
