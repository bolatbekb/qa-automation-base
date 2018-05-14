package backend

import backend.helpers.NetworkManager.Companion.executeGet
import backend.helpers.NetworkManager.Companion.responseGet
import backend.scheme.SeedExpected
import org.assertj.core.api.Assertions.assertThat
import org.testng.annotations.Test

class Temp {

    @Test
    fun getUsername() {
        val username = executeGet("https://randomuser.me/api/1.1/")
                .body
                .jsonPath()
                .getString("results[0].login.username")
        assertThat(username).isNotNull().isNotEmpty()
    }

    @Test
    fun checkUserName() {
        val user = responseGet(url = "https://randomuser.me/api/1.1/",
                responseClass = SeedExpected::class.java)
        assertThat(user.results[0].login.username).isNotNull().isNotEmpty()
    }
}