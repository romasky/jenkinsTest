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
import pages.dropdownPage;
import pages.mainPage;

public class dropdownTest extends baseSeleniumTest {

    @Description("This test successfully checks header text")
    @Epic("Positive test")
    @DisplayName("Test positive header text")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void testPositiveCheckHeaderText() {
        dropdownPage dropdownPage = new mainPage()
                .opendropdownPage();

        assertions.textCompare(testValues.DDT_HEADER,dropdownPage.getHeaderText());
    }


    @Description("This test successfully checks selected option from dropdown menu")
    @Epic("Positive test")
    @DisplayName("Test positive checks selected option")
    @Severity(SeverityLevel.NORMAL)
    @ParameterizedTest
    @ValueSource(strings = {"optionone", "optiontwo"})
    public void testPositiveSelectAndVerifyDropdownValue(String condition) {

        dropdownPage dropdownPage = new mainPage()
                .opendropdownPage();

        if(condition.equals("optionone")) {
            assertions.textCompare("true", dropdownPage.selectValue(condition));
        } else if(condition.equals("optiontwo")) {
            assertions.textCompare("true", dropdownPage.selectValue(condition));
        } else {
            throw new IllegalArgumentException("Condition value is not known: " + condition);
        }
    }
}
