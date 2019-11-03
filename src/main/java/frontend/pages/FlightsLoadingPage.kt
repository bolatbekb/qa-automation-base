package frontend.pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selectors.byClassName
import com.codeborne.selenide.Selenide
import io.qameta.allure.Step

class FlightsLoadingPage {
    val loaderContainer get() = Selenide.element(byClassName("loader-container"))

    @Step("Waiting for the loading to finish")
    fun waitLoading() {
        loaderContainer.waitUntil(Condition.appear, 5000)
        loaderContainer.waitUntil(Condition.disappear, 5000)
    }
}