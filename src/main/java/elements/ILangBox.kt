package elements

import com.codeborne.selenide.Condition.disappear
import com.codeborne.selenide.Selectors.byId
import com.codeborne.selenide.Selenide.element
import io.qameta.allure.Step

interface ILangBox {
    val btnEnglishCA get() = element(byId("enCAEdition"))

    @Step("Click to \"English Canada\" button")
    fun clickEngCaBtn() {
        btnEnglishCA.click()
        btnEnglishCA.shouldBe(disappear.because("Language is visible"))
    }
}