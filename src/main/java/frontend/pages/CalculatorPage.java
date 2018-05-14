package frontend.pages;

import com.codeborne.selenide.Selenide;
import frontend.elements.CalculatorElem;
import frontend.helpers.WrappersJava;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.sleep;
import static java.lang.Double.parseDouble;

public class CalculatorPage {
    private WrappersJava wrapper = new WrappersJava();

    @Step("Open Page")
    public CalculatorPage open(String url) {
        Selenide.open(url);
        sleep(500);
        return this;
    }

    @Step("Check selected Currency IN")
    public String checkCurrencyIn() {
        return wrapper.elements(byClassName("converter-tabCurrencyName")).get(0).text();
    }

    @Step("Check selected Currency OUT")
    public String checkCurrencyOut() {
        return wrapper.elements(byClassName("converter-tabCurrencyName")).get(1).text();
    }

    @Step("Check value in Currency IN")
    public double checkValueCurrencyIn() {
        return parseDouble(wrapper.elements(byName("inputText")).get(0).getValue());
    }

    @Step("Check value in Currency OUT")
    public double checkValueCurrencyOut() {
        return parseDouble(wrapper.elements(byName("inputText")).get(1).getValue());
    }

    public CalculatorElem calculatorElem() {
        return new CalculatorElem();
    }
}
