package main.java.helpers

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.WebDriverRunner
import frontend.helpers.InitDriverProvider
import org.testng.annotations.AfterMethod

open class BaseTest {

    init {
        Configuration.browser = InitDriverProvider()::class.java.name
    }

    @AfterMethod
    fun clearCaches() {
        WebDriverRunner.clearBrowserCache()
        Selenide.clearBrowserCookies()
    }
}