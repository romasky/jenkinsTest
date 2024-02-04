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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.javaScriptAlertsPage;
import pages.mainPage;

public class javaScriptAlertsTest extends baseSeleniumTest {

    /*Open Alerts*/
    @Description("This test successfully checks opening an alerts")
    @Epic("Positive test")
    @DisplayName("Test positive opening an alerts")
    @Severity(SeverityLevel.MINOR)
    @ParameterizedTest
    @ValueSource(strings = {"simple", "confirm", "prompt"})
    public void testPositiveAlertOpen(String condition) {
        javaScriptAlertsPage javaScriptAlertsPage = new mainPage()
                .openJSAlertsPage();

        switch (condition) {
            case "simple" -> {
                javaScriptAlertsPage.openAlert("simple");
                assertions.checkAlertAppears();
            }
            case "confirm" -> {
                javaScriptAlertsPage.openAlert("confirm");
                assertions.checkAlertAppears();
            }
            case "prompt" -> {
                javaScriptAlertsPage.openAlert("prompt");
                assertions.checkAlertAppears();
            }
            default -> throw new IllegalArgumentException("Condition value is not known: " + condition);
        }
    }

    /*Check Alerts Text*/
    @Description("This test successfully checks text on the alerts")
    @Epic("Positive test")
    @DisplayName("Test positive text on alerts")
    @Severity(SeverityLevel.MINOR)
    @ParameterizedTest
    @ValueSource(strings = {"simple", "confirm", "prompt"})
    public void testPositiveAlertCheckText(String condition) {
        javaScriptAlertsPage javaScriptAlertsPage = new mainPage()
                .openJSAlertsPage();

        switch (condition) {
            case "simple" -> {
                javaScriptAlertsPage.checkAlertsText("simple");
                assertions.checkAlertText(testValues.ALERT_TEXT_JSALERT, alertHelpers.getAlertText(driver));
            }
            case "confirm" -> {
                javaScriptAlertsPage.checkAlertsText("confirm");
                assertions.checkAlertText(testValues.ALERT_TEXT_JSALERT_CONFIRM, alertHelpers.getAlertText(driver));
            }
            case "prompt" -> {
                javaScriptAlertsPage.checkAlertsText("prompt");
                assertions.checkAlertText(testValues.ALERT_TEXT_JSALERT_PROMPT, alertHelpers.getAlertText(driver));
            }
            default -> throw new IllegalArgumentException("Condition value is not known: " + condition);
        }
    }

    /*Check Alerts Text Result*/
    @Description("This test successfully checks text on the page Result")
    @Epic("Positive test")
    @DisplayName("Test positive text Result")
    @Severity(SeverityLevel.MINOR)
    @ParameterizedTest
    @ValueSource(strings = {"simpleok", "confirmok", "confirmcancel","promptok", "promptcancel"})
    public void testPositiveAlertCheckTextResult(String condition) {

        javaScriptAlertsPage javaScriptAlertsPage = new mainPage()
                .openJSAlertsPage();

        switch (condition) {
            case "simpleok" -> {
                assertions.textCompare(testValues.JSALERT_OK_TEXT_RESULT, javaScriptAlertsPage.checkAlertsTextResult(condition));
                assertions.checkAlertClosed(driver); }
            case "confirmok" -> {
                    assertions.textCompare(testValues.JSALERT_CONFIRM_OK_TEXT_RESULT, javaScriptAlertsPage.checkAlertsTextResult(condition));
                assertions.checkAlertClosed(driver); }
            case "confirmcancel" -> {
                    assertions.textCompare(testValues.JSALERT_CONFIRM_CANCEL_TEXT_RESULT, javaScriptAlertsPage.checkAlertsTextResult(condition));
                assertions.checkAlertClosed(driver); }
            case "promptok" -> {
                    assertions.textCompare(testValues.JSALERT_PROMPT_TEXT_RESULT_START + testValues.JSALERT_PROMPT_TEXT_RESULT_ENTER, javaScriptAlertsPage.checkAlertsTextResult(condition));
                    assertions.checkAlertClosed(driver); }
            case "promptcancel" -> {
                    assertions.textCompare(testValues.JSALERT_PROMPT_TEXT_RESULT_START + testValues.JSALERT_PROMPT_TEXT_RESULT_NOENTER, javaScriptAlertsPage.checkAlertsTextResult(condition));
                assertions.checkAlertClosed(driver); }
            default -> throw new IllegalArgumentException("Condition value is not known: " + condition);
        }

    }
}
