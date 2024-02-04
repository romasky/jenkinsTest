package testsBySelenium;

import core.baseSeleniumTest;
import helpers.assertions;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.brokenImagesPage;
import pages.mainPage;

import java.io.IOException;

public class brokenImagesTest  extends baseSeleniumTest {


    @Description("This test successfully checks broken images on the page")
    @Epic("Positive test")
    @DisplayName("Test positive broken image on the page")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void testPositiveAbCheckTitleText() throws IOException {
        brokenImagesPage brokenImagesPage = new mainPage()
                .openBrokenImagesPage();

        assertions.checkImageLinks(brokenImagesPage.getImagesLinks());
    }


}
