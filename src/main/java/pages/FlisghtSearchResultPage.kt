package pages

import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.Selectors.byClassName
import com.codeborne.selenide.Selectors.byXpath
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.Selenide.elements
import com.codeborne.selenide.SelenideElement
import helpers.byDataSeId
import helpers.extractInt
import io.qameta.allure.Step

class FlightSearchResultPage {
    //---Title---
    val pageTitle get() = element(byClassName("page-title"))
    //---Table---
    val flightList get() = elements(byDataSeId("flightRowLg")).map { FlightBlockItem(it) }
    val txtPremiumEconomy get() = element(byClassName("image-description-text"))

    @Step("Waiting for the loading to finish")
    fun waitLoading() {
        pageTitle.waitUntil(visible, 10000)
    }

    @Step("Collect search results to list")
    fun getFirstPremiumFlightAfterTime(time: Int): FlightBlockItem {
        return flightList.first {
            it.departTime.text.extractInt() >= time
                    && it.premiumEconomy().isDisplayed }
    }

    @Step("Premium Economy was selected ")
    fun checkSelectedItem(txt: String): Boolean {
        txtPremiumEconomy.shouldBe(visible.because("Not found Premium Economy title"))
        return txtPremiumEconomy.text.contains(txt)
    }

    inner class FlightBlockItem(val item: SelenideElement) {
        val departTime get() = item.find(byXpath(".//*[@class='itinerary-depart-time depart-time']"))

        fun premiumEconomy(): SelenideElement {
            return item.find(byXpath(".//*[contains(@class, 'cabin-item PREM')]"))
        }
    }

}