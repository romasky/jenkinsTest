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
import pages.dynamicContentPage;
import pages.mainPage;

public class dynamicContentTest extends baseSeleniumTest {


    @Description("This test successfully checks header and text on the page")
    @Epic("Positive test")
    @DisplayName("Test positive checks texts on the page")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void testPositiveChecksTextsOnThePage() {

        dynamicContentPage dynamicContentPage = new mainPage()
                .opendynamicContentPage();

        assertions.StringListCompare(testValues.DC_LIST_OF_TEXT_VALUES, dynamicContentPage.getText2());
    }
}
