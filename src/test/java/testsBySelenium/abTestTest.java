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
import pages.abTestPage;
import pages.mainPage;

public class abTestTest extends baseSeleniumTest {



        /*Check title text*/

    @Description("This test successfully checks text title")
    @Epic("Positive test")
    @DisplayName("Test positive text title on the page")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void testPositiveAbCheckTitleText() {
        abTestPage abTestPage = new mainPage()
                .openAbTestPage();

        assertions.textCompare(testValues.AB_TITLE, testValues.AB_TITLE_2, abTestPage.getTitleText());
    }


    /*Check body text*/
    @Description("This test successfully checks body text")
    @Epic("Positive test")
    @DisplayName("Test positive text body on the page")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void testPositiveAbCheckBodyText() {
        abTestPage abTestPage = new mainPage()
                .openAbTestPage();

        assertions.textCompare(testValues.AB_DESCRIPTION, abTestPage.getBodyText());
    }
}


