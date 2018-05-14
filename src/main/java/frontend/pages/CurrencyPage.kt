package frontend.pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Condition.selected
import com.codeborne.selenide.Selectors
import com.codeborne.selenide.Selectors.byClassName
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.sleep
import frontend.elements.CurrencyElem
import frontend.helpers.elements
import io.qameta.allure.Step

class CurrencyPage {

    @Step("Open page")
    fun open(url: String): CurrencyPage {
        Selenide.open(url)
        sleep(500)
        return this
    }

    @Step("Check selected Currency IN")
    fun checkCurrencyIn(): String? {
        return elements(byClassName("converter-tabCurrencyName"))[0].text()
    }

    @Step("Check selected Currency OUT")
    fun checkCurrencyOut(): String? {
        return elements(byClassName("converter-tabCurrencyName"))[1].text()
    }

    @Step("Check value in Currency IN")
    fun checkValueCurrencyIn(): String? {
        return elements(Selectors.byName("inputText"))[0].value
    }

    @Step("Check value in Currency OUT")
    fun checkValueCurrencyOut(): String? {
        return elements(Selectors.byName("inputText"))[1].value
    }

    fun currencyElem(): CurrencyElem {
        return CurrencyElem()
    }



}