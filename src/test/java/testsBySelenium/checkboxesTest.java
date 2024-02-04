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
import pages.checkboxesPage;
import pages.mainPage;

public class checkboxesTest extends baseSeleniumTest {


    @Description("This test successfully checks header text")
    @Epic("Positive test")
    @DisplayName("Test positive header text")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void testPositiveCheckHeaderText() {
        checkboxesPage checkboxesPage = new mainPage()
                .openCheckboxesPage();
         assertions.textCompare(testValues.CHBX_HEADER_TEXT,checkboxesPage.getHeaderText());
    }

    @Description("This test successfully checks names of checkboxes")
    @Epic("Positive test")
    @DisplayName("Test positive checks names of checkboxes")
    @Severity(SeverityLevel.NORMAL)
    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    public void testPositiveNamesOfCheckboxes(int condition) {
        checkboxesPage checkboxesPage = new mainPage()
                .openCheckboxesPage();
        if(condition==0) {
            assertions.textCompare(testValues.CHBX_NAME_FIRST_CHECKBOX,checkboxesPage.getCheckboxNames(condition));
        } else if(condition==1) {
            assertions.textCompare(testValues.CHBX_NAME_SECOND_CHECKBOX,checkboxesPage.getCheckboxNames(condition));
        } else {
            throw new IllegalArgumentException("Condition value is not known: " + condition);
        }
    }

    @Description("This test successfully checks checkboxes before click")
    @Epic("Positive test")
    @DisplayName("Test positive checks checkboxes before click")
    @Severity(SeverityLevel.NORMAL)
    @ParameterizedTest
    @ValueSource(strings = {"first", "second"})
    public void testPositiveCheckboxesBeforeClick(String condition) {
        checkboxesPage checkboxesPage = new mainPage()
                .openCheckboxesPage();
        if(condition.equals("first")) {
            assertions.checkAttribute(null,checkboxesPage.getAttributeBeforeClick(condition));
        } else if(condition.equals("second")) {
            assertions.checkAttribute("true",checkboxesPage.getAttributeBeforeClick(condition));
        } else {
            throw new IllegalArgumentException("Condition value is not known: " + condition);
        }
    }

    @Description("This test successfully checks checkboxes after click")
    @Epic("Positive test")
    @DisplayName("Test positive checks checkboxes after click")
    @Severity(SeverityLevel.NORMAL)
    @ParameterizedTest
    @ValueSource(strings = {"first", "second"})
    public void testPositiveCheckboxesAfterClick(String condition) {
        checkboxesPage checkboxesPage = new mainPage()
                .openCheckboxesPage();
        if(condition.equals("first")) {
            assertions.checkAttribute("true",checkboxesPage.getAttributeAfterClick(condition));
        } else if(condition.equals("second")) {
            assertions.checkAttribute(null,checkboxesPage.getAttributeAfterClick(condition));
        } else {
            throw new IllegalArgumentException("Condition value is not known: " + condition);
        }
    }

    @Description("This test successfully checks number of checkboxes")
    @Epic("Positive test")
    @DisplayName("Test positive number of checkboxes")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void testPositiveCheckNumberOfCheckboxes() {
        checkboxesPage checkboxesPage = new mainPage()
                .openCheckboxesPage();
        assertions.integerCompare(testValues.CHBX_NUMBER_OF_CHECKBOXES,checkboxesPage.numberOfCheckboxes());
    }



}
