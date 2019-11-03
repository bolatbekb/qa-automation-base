package frontend

import frontend.helpers.BaseTest
import frontend.pages.FlightsLoadingPage
import frontend.pages.MainPage
import org.testng.annotations.Test

@Test(groups = ["skyGlobal"])
class SkyGlobalTest : BaseTest() {
    val mainPage = MainPage()
    val flightsLoadingPage = FlightsLoadingPage()

    @Test(testName = "Find premium economy")
    fun badAuthTest() {
        mainPage.open()
        mainPage.clickEngCaBtn()
        mainPage.selectRoundTrip()
        mainPage.typeDepartureCity("YVR")
        mainPage.typeArrivalCity("YYZ")
        mainPage.selectDates("July", "15", "July", "22")
        mainPage.clickFind()

        flightsLoadingPage.waitLoading()
    }
}