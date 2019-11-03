package frontend.helpers

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.WebDriverProvider
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import java.net.URL

open class InitDriverProvider : WebDriverProvider {

    var HUB_URL = System.getProperty("HUB_URL").let { "localhost" }

    override fun createDriver(capabilities: DesiredCapabilities) =
            ChromeOptions()
                    .apply {
                        setCapability("version", "78")
                        setCapability("enableVNC", true)
                    }.run { RemoteWebDriver(URL("http://$HUB_URL:4444/wd/hub"), this) }

    init {
        Configuration.baseUrl = "https://www.aircanada.com"
        Configuration.browserSize = "1920x1080"
        Configuration.timeout = 15000
        Configuration.reopenBrowserOnFail = true
    }
}