package frontend.pages

import com.codeborne.selenide.Selenide
import frontend.elements.ILangBox
import frontend.elements.IFlightSearchMenu
import io.qameta.allure.Step

class MainPage : ILangBox, IFlightSearchMenu {

    @Step("Open main page")
    fun open() {
        Selenide.open("/")
    }
}