package testsBySelenium;

import core.baseSeleniumTest;
import helpers.assertions;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.addRemovePage;
import pages.mainPage;

public class addRemoveTest extends baseSeleniumTest {


    /*Check Button "Detele" appears N times*/
    @Description("This test successfully checks button \"Delete\" appears on the page")
    @Epic("Positive test")
    @DisplayName("Test positive text button \"Delete\" appears")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void testPositiveCheckDeleteButtonAppears() {
        addRemovePage addRemovePage = new mainPage()
                .openaddRemovePage();
        addRemovePage.clickAddElementButton();

        assertions.deleteButtonAppearsNTimes(addRemovePage);
    }


    /*Check Button "Detele" appears and clicks N times*/
    @Description("This test successfully checks button \"Delete\" appears and disappears on the page after click")
    @Epic("Positive test")
    @DisplayName("Test positive text button \"Delete\" disappears")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void testPositiveCheckDeleteButtonsDisappear() {
        addRemovePage addRemovePage = new mainPage()
                .openaddRemovePage();
        addRemovePage.deleteButtonAppears();

        assertions.zeroListSize(addRemovePage);
    }





}
