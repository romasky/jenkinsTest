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
import pages.dragAndDropPage;
import pages.mainPage;

public class dragAndDropTest extends baseSeleniumTest {


    @Description("This test successfully checks header text")
    @Epic("Positive test")
    @DisplayName("Test positive header text")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void testPositiveCheckHeaderText() {
        dragAndDropPage dragAndDropPage = new mainPage()
                .opendragAndDropPage();

        assertions.textCompare(testValues.DD_HEADER,dragAndDropPage.getHeaderText());
    }


    @Description("This test successfully drag and drop A to B")
    @Epic("Positive test")
    @DisplayName("Test positive drag and drop A to B")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void testPositiveCheckNumberOfButtonsAndTheirNames() {
        dragAndDropPage dragAndDropPage = new mainPage()
                .opendragAndDropPage();

        dragAndDropPage.dragAndDropAToB();
        assertions.textCompare(testValues.DD_A, dragAndDropPage.getBoxBText());
    }



}
