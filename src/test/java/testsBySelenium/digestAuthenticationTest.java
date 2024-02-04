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
import pages.digestAuthenticationPage;
import pages.mainPage;

public class digestAuthenticationTest extends baseSeleniumTest {

    /*Open Basic Auth Page*/
    @Description("This test successfully checks login with basic auth on the page")
    @Epic("Positive test")
    @DisplayName("Test positive login on the page")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void testPositiveSuccessfullylogin() {
        digestAuthenticationPage digestAuthenticationPage = new mainPage()
                .digestAuthenticationPage();

        assertions.textCompare(testValues.DA_HEADER, digestAuthenticationPage.getTextFromPage("titleAuthText"));
        assertions.textCompare(testValues.DA_TEXT, digestAuthenticationPage.getTextFromPage("bodyAuthText"));
    }

}
