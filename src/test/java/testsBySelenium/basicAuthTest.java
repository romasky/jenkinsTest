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
import pages.basicAuthPage;
import pages.mainPage;

public class basicAuthTest extends baseSeleniumTest {


    /*Open Basic Auth Page*/
    @Description("This test successfully checks login with basic auth on the page")
    @Epic("Positive test")
    @DisplayName("Test positive login on the page")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void testPositiveSuccessfullyloginViaAlert() {
        basicAuthPage basicAuthPage = new mainPage()
                .openbasicAuthPage();

        assertions.textCompare(testValues.BAT_TITLE_TEXT, basicAuthPage.getTextFromPage("titleAuthText"));
        assertions.textCompare(testValues.BAT_BODY_TEXT, basicAuthPage.getTextFromPage("bodyAuthText"));
    }
}
