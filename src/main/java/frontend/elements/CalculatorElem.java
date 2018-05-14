package frontend.elements;

import com.codeborne.selenide.ElementsContainer;
import frontend.helpers.WrappersJava;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byName;

public class CalculatorElem extends ElementsContainer {
    private WrappersJava wrapper = new WrappersJava();

    @Step("Select popular Currency")
    public CalculatorElem selectPopularCurrency(String currency) {
        wrapper.elements(byClassName("converter-popularItem")).findBy(text(currency)).click();
        return this;
    }

    @Step("Select region Currency")
    public CalculatorElem selectAllCurrency(String currency) {
        wrapper.elements(byClassName("converter-currenciesSymbol")).findBy(text(currency)).click();
        return this;
    }

    @Step("Input currency IN")
    public CalculatorElem inputCurrencyIn(String currency) {
        wrapper.elements(byName("inputText")).get(0).setValue(currency);
        return this;
    }

    @Step("Input currency OUT")
    public CalculatorElem inputCurrencyOut(String currency) {
        wrapper.elements(byName("inputText")).get(1).setValue(currency);
        return this;
    }

    @Step("Click on Clear button")
    public CalculatorElem clearButtonClick() {
        wrapper.element(byClassName("ui-btnTxt")).click();
        return this;
    }
}
