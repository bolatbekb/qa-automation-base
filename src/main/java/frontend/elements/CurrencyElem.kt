package frontend.elements

import com.codeborne.selenide.Condition.text
import com.codeborne.selenide.ElementsContainer
import com.codeborne.selenide.Selectors.byClassName
import com.codeborne.selenide.Selectors.byName
import frontend.helpers.element
import frontend.helpers.elements
import frontend.pages.CurrencyPage
import io.qameta.allure.Step

class CurrencyElem : ElementsContainer() {

    @Step("Select popular Currency")
    fun selectPopularCurrency(currency: String): CurrencyElem {
        elements(byClassName("converter-popularItem")).findBy(text(currency)).click()
        return this
    }

    @Step("Select region Currency")
    fun selectAllCurrency(currency: String): CurrencyElem {
        elements(byClassName("converter-currenciesSymbol")).findBy(text(currency)).click()
        return this
    }

    @Step("Input currency IN")
    fun inputCurrencyIn(currency: String): CurrencyElem {
        elements(byName("inputText"))[0].setValue(currency)
        return this
    }

    @Step("Input currency OUT")
    fun inputCurrencyOut(currency: String): CurrencyElem {
        elements(byName("inputText"))[1].setValue(currency)
        return this
    }

    @Step("Click on Clear button")
    fun clearButtonClick(): CurrencyElem {
        element(byClassName("ui-btnTxt")).click()
        return this
    }
}