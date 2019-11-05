package helpers

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.WebDriverRunner
import org.testng.annotations.AfterMethod

open class BaseTest {

    init {
        Configuration.browser = InitDriverProvider()::class.java.name
    }

    @AfterMethod(alwaysRun = true)
    fun clearCache() {
        WebDriverRunner.clearBrowserCache()
        Selenide.clearBrowserCookies()
    }
}