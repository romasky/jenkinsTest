package testsBySelenium;

import core.baseSeleniumTest;
import helpers.assertions;
import helpers.testValues;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.disappearingElementsPage;
import pages.mainPage;

public class disappearingElementsTest extends baseSeleniumTest {

    @Description("This test successfully checks texts")
    @Epic("Positive test")
    @DisplayName("Test positive checks texts")
    @Severity(SeverityLevel.NORMAL)
    @ParameterizedTest
    @ValueSource(strings = {"headerText", "bodyText"})
    public void testPositiveCheckTextOnThePage(String condition) {

        disappearingElementsPage disappearingElementsPage = new mainPage()
                .opendisappearingElementsPage();

        if(condition.equals("headerText")) {
            assertions.textCompare(testValues.DE_HEADER,disappearingElementsPage.getTextFromPage(condition));
        } else if(condition.equals("bodyText")) {
            assertions.textCompare(testValues.DE_TEXT,disappearingElementsPage.getTextFromPage(condition));
        } else {
            throw new IllegalArgumentException("Condition value is not known: " + condition);
        }
    }



    @Description("This test successfully checks number of buttons")
    @Epic("Positive test")
    @DisplayName("Test positive number of buttons")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void testPositiveCheckNumberOfButtonsAndTheirNames() {
        disappearingElementsPage disappearingElementsPage = new mainPage()
                .opendisappearingElementsPage();

        assertions.checkButtons(testValues.DE_BUTTONS_NAME,disappearingElementsPage.getButtonsList());
    }

}
