package frontend

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.sleep
import com.codeborne.selenide.WebDriverRunner
import frontend.pages.CurrencyPage
import io.qameta.allure.Feature
import io.qameta.allure.Story
import main.java.helpers.BaseTest
import org.assertj.core.api.Assertions.assertThat
import org.testng.annotations.AfterMethod
import org.testng.annotations.Test

@Feature("Kotlin")
@Story("Converter")
@Test(groups = ["calculator"])
class CurrencyTest : BaseTest() {

    @AfterMethod(alwaysRun = true)
    fun clearCache() {
        WebDriverRunner.clearBrowserCache()
        Selenide.clearBrowserCookies()
    }

    @Test(description = "Check the selection of Popular currencies")
    fun checkPopularCurrency() {
        CurrencyPage()
                .open("/")
                .currencyElem()
                .selectPopularCurrency("CAD")
        assertThat(CurrencyPage().checkCurrencyIn()).isEqualTo("CAD")
    }

    @Test(description = "Check the set of Region currencies")
    fun checkRegionCurrency() {
        CurrencyPage()
                .open("/")
                .currencyElem()
                .selectAllCurrency("AUD")
        assertThat(CurrencyPage().checkCurrencyIn()).isEqualTo("AUD")
    }

    @Test(description = "Check the set to Currency IN")
    fun checkSetCurrencyValueIn() {
        CurrencyPage()
                .open("/")
                .currencyElem()
                .selectPopularCurrency("CAD")
                .inputCurrencyIn("10")
        assertThat(CurrencyPage().checkValueCurrencyIn()!!.toInt()).isEqualTo(10)
        assertThat(CurrencyPage().checkValueCurrencyOut()!!.toDouble()).isGreaterThan(0.0)
    }

    @Test(description = "Check the set to Currency OUT")
    fun checkSetCurrencyValueOut() {
        CurrencyPage()
                .open("/")
                .currencyElem()
                .selectAllCurrency("HRK")
                .inputCurrencyOut("10")
        assertThat(CurrencyPage().checkValueCurrencyIn()!!.toDouble()).isGreaterThan(0.0)
        assertThat(CurrencyPage().checkValueCurrencyOut()!!.toInt()).isEqualTo(10)
    }

    @Test(description = "Check Clear button")
    fun checkClearCurrencyInput() {
        CurrencyPage()
                .open("/")
                .currencyElem()
                .inputCurrencyIn("10")
                .clearButtonClick()
        assertThat(CurrencyPage().checkValueCurrencyIn()!!.toInt()).isEqualTo(0)
        assertThat(CurrencyPage().checkValueCurrencyOut()!!.toInt()).isEqualTo(0)
    }
}