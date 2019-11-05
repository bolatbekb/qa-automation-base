package pages

import com.codeborne.selenide.Selenide
import elements.IFlightSearchMenu
import elements.ILangBox
import io.qameta.allure.Step

class MainPage : ILangBox, IFlightSearchMenu {

    @Step("Open main page")
    fun open() {
        Selenide.open("/")
    }
}