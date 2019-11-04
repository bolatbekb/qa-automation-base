package frontend.pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selectors
import com.codeborne.selenide.Selectors.byXpath
import com.codeborne.selenide.Selenide.*
import frontend.helpers.byDataSeId
import io.qameta.allure.Step

class FlightSearchResultPage {
    //---Title---
    val pageTitle get() = element(Selectors.byClassName("page-title"))
    //---Table---
    val flightDepartureTime get() = element(byXpath(".//*[contains(@id, \"itineraryDepartTime\")]"))
    val flightPremium get() = element(byXpath(".//*[contains(@id, \"cabinBtnPREM\")]"))
    val flightList get() = elements(byDataSeId("flightRowLg"))

    @Step("Waiting for the loading to finish")
    fun waitLoading() {
        pageTitle.waitUntil(Condition.visible,5000)
    }

    @Step("Collect search results to list")
    fun getSearchResults() {

    }

}

data class FlightItems(
        var departureTime: Int,
        var premiumEconomy: Boolean?
)