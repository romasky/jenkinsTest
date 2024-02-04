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
import pages.challengingDOMPage;
import pages.mainPage;

public class challengingDOMTest extends baseSeleniumTest {

    @Description("This test successfully checks list of buttons size")
    @Epic("Positive test")
    @DisplayName("Test positive number of buttons")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void testPositiveCheckListOfButtonsSize() {
        challengingDOMPage challengingDOMPage = new mainPage()
                .openChallengingDOMPage();

        assertions.integerCompare(testValues.CDOM_BUTTONS_LIST_SIZE,challengingDOMPage.getListOfButtonsSize());
    }

    @Description("This test successfully checks header text")
    @Epic("Positive test")
    @DisplayName("Test positive header text")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void testPositiveCheckHeaderText() {
        challengingDOMPage challengingDOMPage = new mainPage()
                .openChallengingDOMPage();

        assertions.textCompare(testValues.CDOM_HEADER_TEXT,challengingDOMPage.getHeaderText());
    }

    @Description("This test successfully checks body text")
    @Epic("Positive test")
    @DisplayName("Test positive body text")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void testPositiveCheckBodyText() {
        challengingDOMPage challengingDOMPage = new mainPage()
                .openChallengingDOMPage();

        assertions.textCompare(testValues.CDOM_BODY_TEXT,challengingDOMPage.getBodyText());
    }

    @Description("This test successfully checks the operation of the element 'button' in blue and element attribute 'id' is changed after the button is clicked")
    @Epic("Positive test")
    @DisplayName("Test positive press buttons")
    @Severity(SeverityLevel.NORMAL)
    @ParameterizedTest
    @ValueSource(strings = {"blue", "red", "green"})
    public void testPositiveCheckBlueButton(String condition) {
        challengingDOMPage challengingDOMPage = new mainPage()
                .openChallengingDOMPage();

        if(condition.equals("blue")) {
            assertions.BooleanCompare(true,challengingDOMPage.checkButtonAttributeIdIsDifferent(condition));
        } else if(condition.equals("red")) {
            assertions.BooleanCompare(true,challengingDOMPage.checkButtonAttributeIdIsDifferent(condition));
        }
        else if(condition.equals("green")) {
            assertions.BooleanCompare(true,challengingDOMPage.checkButtonAttributeIdIsDifferent(condition));
        } else {
            throw new IllegalArgumentException("Condition value is not known: " + condition);
        }
    }

    @Description("This test successfully checks static headers of the table")
    @Epic("Positive test")
    @DisplayName("Test positive table headers")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void testPositiveCheckTableHeaders() {
        challengingDOMPage challengingDOMPage = new mainPage()
                .openChallengingDOMPage();

        assertions.StringListCompare(testValues.CDOM_TABLE_HEADERS,challengingDOMPage.getTableHeadersList());
    }

    @Description("This test successfully checks list of table rows size")
    @Epic("Positive test")
    @DisplayName("Test positive table row size")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void testPositiveCheckListOfTableRowSize() {
        challengingDOMPage challengingDOMPage = new mainPage()
                .openChallengingDOMPage();

        assertions.integerCompare(testValues.CDOM_TABLE_LIST_ROWS_SIZE,challengingDOMPage.getListOfTableRowsSize());
    }

    @Description("This test successfully checks list of table cells")
    @Epic("Positive test")
    @DisplayName("Test positive table cells")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void testPositiveCheckListOfTableCells() {
        challengingDOMPage challengingDOMPage = new mainPage()
                .openChallengingDOMPage();

        assertions.checkNotNullListItems(challengingDOMPage.getTableCellsItemsList());
    }

    @Description("This test successfully checks url after click on Edit button")
    @Epic("Positive test")
    @DisplayName("Test positive click on Edit button")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void testPositiveCheckUrlAfterEditButton() {
        challengingDOMPage challengingDOMPage = new mainPage()
                .openChallengingDOMPage();

        assertions.textCompare(testValues.CDOM_EDIT_LINK, challengingDOMPage.checkButtonEdit());
    }

    @Description("This test successfully checks url after click on Delete button")
    @Epic("Positive test")
    @DisplayName("Test positive click on Delete button")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void testPositiveCheckUrlAfterDeleteButton() {
        challengingDOMPage challengingDOMPage = new mainPage()
                .openChallengingDOMPage();

        assertions.textCompare(testValues.CDOM_DELETE_LINK, challengingDOMPage.checkDeleteButtonEdit());
    }

    @Description("This test successfully checks canvas numbers are not equals after refresh")
    @Epic("Positive test")
    @DisplayName("Test positive checks canvas numbers")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void testPositiveCheckCanvasNumbersAfterRefresh() {
        challengingDOMPage challengingDOMPage = new mainPage()
                .openChallengingDOMPage();

        assertions.BooleanCompare(true, challengingDOMPage.checkNumberIsDifferentAfterRefresh());
    }


    @Description("This test successfully checks the operation of the element 'button' in blue and element attribute 'id' is changed after the button is clicked")
    @Epic("Positive test")
    @DisplayName("Test positive press buttons")
    @Severity(SeverityLevel.NORMAL)
    @ParameterizedTest
    @ValueSource(strings = {"width", "height", "style"})
    public void testPositiveCheckCanvasAttribute(String condition) {
        challengingDOMPage challengingDOMPage = new mainPage()
                .openChallengingDOMPage();

        if(condition.equals("width")) {
            assertions.textCompare(testValues.CDOM_CANVAS_WIDTH,challengingDOMPage.getCanvasAttribute("width"));
        } else if(condition.equals("height")) {
            assertions.textCompare(testValues.CDOM_CANVAS_HEIGHT,challengingDOMPage.getCanvasAttribute("height"));
        }
        else if(condition.equals("style")) {
            assertions.textCompare(testValues.CDOM_CANVAS_STYLE,challengingDOMPage.getCanvasAttribute("style"));
        } else {
            throw new IllegalArgumentException("Condition value is not known: " + condition);
        }
    }
}
