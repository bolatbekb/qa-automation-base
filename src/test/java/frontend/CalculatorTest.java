package frontend;

import frontend.pages.CalculatorPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import main.java.helpers.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;
import static org.assertj.core.api.Assertions.assertThat;

@Feature("Java")
@Story("Converter")
@Test(groups = "calculator")
public class CalculatorTest extends BaseTest {
    private CalculatorPage calculatorPage = new CalculatorPage();

    @AfterMethod(alwaysRun = true)
    private void setUp() {
        clearBrowserCache();
        clearBrowserCookies();
    }

    @Test(description = "Check the selection of Popular currencies")
    private void checkPopularCurrency() {
        calculatorPage
                .open("/")
                .calculatorElem()
                .selectPopularCurrency("USD");
        assertThat(calculatorPage.checkCurrencyIn()).isEqualTo("USD");
    }

    @Test(description = "Check the set of Region currencies")
    private void checkRegionCurrency() {
        calculatorPage
                .open("/")
                .calculatorElem()
                .selectAllCurrency("AUD");

        assertThat(calculatorPage.checkCurrencyIn()).isEqualTo("AUD");

    }

    @Test(description = "Check the set to Currency value IN")
    private void checkSetCurrencyValueIn() {
        calculatorPage
                .open("/")
                .calculatorElem()
                .selectPopularCurrency("CAD")
                .inputCurrencyIn("10");

        assertThat(calculatorPage.checkValueCurrencyIn()).isEqualTo(10);
        assertThat(calculatorPage.checkValueCurrencyOut()).isGreaterThan(0);
    }

    @Test(description = "Check the set to Currency value OUT")
    private void checkSetCurrencyValueOut() {
        calculatorPage
                .open("/")
                .calculatorElem()
                .selectAllCurrency("HRK")
                .inputCurrencyOut("10");

        assertThat(calculatorPage.checkValueCurrencyIn()).isGreaterThan(0);
        assertThat(calculatorPage.checkValueCurrencyOut()).isEqualTo(10);
    }

    @Test(description = "Check Clear button")
    private void checkClearCurrencyInput() {
        calculatorPage
                .open("/")
                .calculatorElem()
                .inputCurrencyIn("10")
                .clearButtonClick();

        assertThat(calculatorPage.checkValueCurrencyIn()).isEqualTo(0);
        assertThat(calculatorPage.checkValueCurrencyOut()).isEqualTo(0);
    }

}
