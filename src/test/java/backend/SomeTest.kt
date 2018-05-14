package backend

import backend.helpers.EndpointsGet
import backend.helpers.NetworkManager.Companion.executeGet
import backend.helpers.NetworkManager.Companion.responseGet
import backend.scheme.SeedExpected
import org.assertj.core.api.Assertions.assertThat
import org.testng.ITestContext
import org.testng.annotations.Test

@Test(groups = ["api"])
class SomeTest {

    @Test(testName = "Get one user")
    fun checkUserName(context: ITestContext) {
        val user = executeGet(EndpointsGet.NEW.hand).body.asString()
        context.setAttribute("response", user)
        assertThat(user).contains("name")
    }

    @Test(testName = "Check seed")
    fun checkSeed() {
        val seed = responseGet(url = EndpointsGet.SEED.hand, responseClass = SeedExpected::class.java)
        assertThat(seed.results[0].name.first).isEqualTo("becky")
    }
}