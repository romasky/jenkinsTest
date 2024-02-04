package testsBySelenium;

import core.baseSeleniumTest;
import helpers.alertHelpers;
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
import pages.contextMenuPage;
import pages.mainPage;


public class contextMenuTest extends baseSeleniumTest {


    @Description("This test successfully checks header text")
    @Epic("Positive test")
    @DisplayName("Test positive header text")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void testPositiveCheckHeaderText() {
        contextMenuPage contextMenuPage = new mainPage()
                .openContextMenuPage();

        assertions.textCompare(testValues.CM_HEADER,contextMenuPage.getHeaderText());
    }


    @Description("This test successfully checks texts")
    @Epic("Positive test")
    @DisplayName("Test positive checks texts")
    @Severity(SeverityLevel.NORMAL)
    @ParameterizedTest
    @ValueSource(strings = {"first", "second"})
    public void testPositiveNamesOfCheckboxes(String condition) {
        contextMenuPage contextMenuPage = new mainPage()
                .openContextMenuPage();
        if(condition.equals("first")) {
            assertions.textCompare(testValues.CM_FIRST_TEXT,contextMenuPage.getTextNames(condition));
        } else if(condition.equals("second")) {
            assertions.textCompare(testValues.CM_SECOND_TEXT,contextMenuPage.getTextNames(condition));
        } else {
            throw new IllegalArgumentException("Condition value is not known: " + condition);
        }
    }

    @Description("This test successfully checks opening an alerts")
    @Epic("Positive test")
    @DisplayName("Test positive opening an alerts")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void testPositiveAlertOpen() {
        contextMenuPage contextMenuPage = new mainPage()
                .openContextMenuPage();

        contextMenuPage.openAlert();
        assertions.checkAlertAppears();
    }

    @Description("This test successfully checks text on the alerts")
    @Epic("Positive test")
    @DisplayName("Test positive text on alerts")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void testPositiveAlertCheckText() {
        contextMenuPage contextMenuPage = new mainPage()
                .openContextMenuPage();

        contextMenuPage.openAlert();
        assertions.checkAlertText(testValues.CM_ALERT_TEXT, alertHelpers.getAlertText(driver));
    }
}
