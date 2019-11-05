package elements

import com.codeborne.selenide.Condition.text
import com.codeborne.selenide.Selectors.*
import com.codeborne.selenide.Selenide.*
import helpers.byDataSeId
import helpers.byKeyventId
import io.qameta.allure.Step

interface IFlightSearchMenu {
    //---TripType---
    val radioRoundTrip get() = element(byId("roundTrip"))
    //---Directions---
    val inpFrom get() = element(byId("origin_R_0"))
    val inpTo get() = element(byId("destination_R_0"))
    //---Calendar---
    val flightCalendar get() = element(byKeyventId("returnDate"))
    val btnNextMonth get() = element(byTitle("Next"))
    val months get() = elements(byClassName("ui-datepicker-month"))
    val days get() = elements(byXpath(".//*[contains(@class, 'ui-state-default ui-calendar-date')]"))
    val submitCalendar get() = element(byId("calendarSelectActionBtn"))
    //---Find---
    val btnFind get() = element(byDataSeId("btnFlightsSearchOption2"))

    @Step("Select Round trip")
    fun selectRoundTrip() {
        if (!radioRoundTrip.isSelected) radioRoundTrip.click()
    }

    @Step("Type departure city")
    fun typeDepartureCity(cityCode: String) {
        inpFrom.apply {
            value = cityCode
            sleep(500)
            pressEnter()
        }
    }

    @Step("Type arrival city")
    fun typeArrivalCity(cityCode: String) {
        inpTo.apply {
            value = cityCode
            sleep(500)
            pressEnter()
        }
    }

    @Step("Select dates")
    fun selectDates(fromMonth: String, fromDay: String, toMonth: String, toDay: String) {
        flightCalendar.click()
        scrollToMonth(fromMonth)
        selectDay(fromDay)
        scrollToMonth(toMonth)
        selectDay(toDay)
        submitCalendar.click()
    }

    @Step("Scroll to selected month")
    fun scrollToMonth(month: String) {
        while (months.first().text() != month) { btnNextMonth.click() }
        months.first().shouldBe(text(month).because("Wrong month"))
    }

    @Step("Click to selected day")
    fun selectDay(day: String) {
        days.first { it.text == day }.click()
    }

    @Step("Click to find button")
    fun clickFind() {
        btnFind.click()
    }
}