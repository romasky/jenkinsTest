package pages;

import core.baseSeleniumPage;
import helpers.alertHelpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class contextMenuPage extends baseSeleniumPage {

    private final Logger logger = LogManager.getLogger(contextMenuPage.class);

    Actions actions = new Actions(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    @FindBy(xpath = "//h3")
    private WebElement headerText;

    @FindAll(@FindBy(xpath = "//p"))
    private List<WebElement> texts;

    @FindBy(id = "hot-spot")
    private WebElement hotSpot;

    public contextMenuPage() {
        PageFactory.initElements(driver, this);
    }



    public String getHeaderText() {
        logger.info("Get header text");
        return headerText.getText();
    }

    public String getTextNames(String text) {
        switch (text.toLowerCase()) {
            case "first":
                logger.info("First text is:" + texts.get(0).getText());
                return texts.get(0).getText();
            case "second":
                logger.info("First text is:" + texts.get(1).getText());
                return texts.get(1).getText();
            default:
                throw new IllegalArgumentException("Invalid text: " + text);
        }
    }

    public void openAlert() {
        actions.contextClick(hotSpot).perform();
        wait.until(ExpectedConditions.alertIsPresent());
        alertHelpers.alertHandler(driver);
        logger.info("Alert is open");
    }
}
