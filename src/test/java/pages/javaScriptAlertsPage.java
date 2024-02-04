package pages;

import core.baseSeleniumPage;
import helpers.alertHelpers;
import helpers.testValues;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class javaScriptAlertsPage extends baseSeleniumPage {

    private final Logger logger = LogManager.getLogger(javaScriptAlertsPage.class);

    @FindBy(xpath = "//button[@onclick='jsAlert()']")
    private WebElement jsAlertButton;

    @FindBy(xpath = "//button[@onclick='jsConfirm()']")
    private WebElement jsConfirmAlertButton;

    @FindBy(xpath = "//button[@onclick='jsPrompt()']")
    private WebElement jsPromptAlertButton;

    @FindBy(xpath = "//p[@id]")
    private WebElement jsAlertResultText;


    public javaScriptAlertsPage() {
        PageFactory.initElements(driver, this);
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    /*Open Alerts*/

    public void openAlert(String type) {
        switch (type.toLowerCase()) {
            case "simple" -> jsAlertButton.click();
            case "confirm" -> jsConfirmAlertButton.click();
            case "prompt" -> jsPromptAlertButton.click();
            default -> throw new IllegalArgumentException("Invalid alert type: " + type);
        }

        wait.until(ExpectedConditions.alertIsPresent());
        alertHelpers.alertHandler(driver);
        logger.info("Alert " +type+ " is open");
    }

    /*Check Alerts Text*/

    public void checkAlertsText(String type) {
        switch (type.toLowerCase()) {
            case "simple" -> jsAlertButton.click();
            case "confirm" -> jsConfirmAlertButton.click();
            case "prompt" -> jsPromptAlertButton.click();
            default -> throw new IllegalArgumentException("Invalid alert type: " + type);
        }

        wait.until(ExpectedConditions.alertIsPresent());
        logger.info("Alert " +type+ " is open");
    }

    /*Check Alerts Text Result*/

    public String checkAlertsTextResult(String type) {
        switch (type.toLowerCase()) {
            case "simpleok":
                jsAlertButton.click();
                wait.until(ExpectedConditions.alertIsPresent());
                logger.info("Simple Alert is open");
                alertHelpers.acceptAlert(driver);
                break;
            case "confirmok":
                jsConfirmAlertButton.click();
                wait.until(ExpectedConditions.alertIsPresent());
                logger.info("Confirm Alert is open");
                alertHelpers.acceptAlert(driver);
                break;
            case "confirmcancel":
                jsConfirmAlertButton.click();
                wait.until(ExpectedConditions.alertIsPresent());
                logger.info("Confirm Alert is open");
                alertHelpers.dismissAlert(driver);
                break;
            case "promptok":
                jsPromptAlertButton.click();
                wait.until(ExpectedConditions.alertIsPresent());
                logger.info("Confirm Alert is open");
                alertHelpers.sendKeysToAlert(driver, testValues.JSALERT_PROMPT_TEXT_RESULT_ENTER);
                alertHelpers.acceptAlert(driver);
                break;
            case "promptcancel":
                jsPromptAlertButton.click();
                wait.until(ExpectedConditions.alertIsPresent());
                logger.info("Confirm Alert is open");
                alertHelpers.dismissAlert(driver);
                break;
            default:
                throw new IllegalArgumentException("Invalid alert type: " + type);
        }

        return jsAlertResultText.getText();
    }
}
