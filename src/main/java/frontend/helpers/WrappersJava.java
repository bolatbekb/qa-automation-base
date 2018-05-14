package frontend.helpers;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WrappersJava {

    public SelenideElement element(By bySelector) {
        return $(bySelector);
    }

    public SelenideElement element(String selector) {
        return $(selector);
    }

    public ElementsCollection elements(By bySelector) {
        return $$(bySelector);
    }

    public ElementsCollection elements(String selector) {
        return $$(selector);
    }
}
