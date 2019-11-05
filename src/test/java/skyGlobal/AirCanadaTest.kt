package skyGlobal

import helpers.BaseTest
import pages.FlightSearchResultPage
import pages.MainPage
import org.assertj.core.api.Assertions.assertThat
import org.testng.annotations.Test

@Test(groups = ["skyGlobal"])
class AirCanadaTest : BaseTest() {
    val mainPage = MainPage()
    val flightSearchResultPage = FlightSearchResultPage()

    @Test(testName = "Find first premium economy after 7 AM")
    fun findFirstPremiumEconomyTest() {
        mainPage.open()
        mainPage.clickEngCaBtn()
        mainPage.selectRoundTrip()
        mainPage.typeDepartureCity("YVR")
        mainPage.typeArrivalCity("YYZ")
        mainPage.selectDates("July", "15", "July", "22")
        mainPage.clickFind()

        flightSearchResultPage.waitLoading()
        flightSearchResultPage.getFirstPremiumFlightAfterTime(700).premiumEconomy().click()

        assertThat(flightSearchResultPage.checkSelectedItem("Premium Economy")).isTrue()
    }
}


















