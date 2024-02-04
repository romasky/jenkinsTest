package pages;

import core.baseSeleniumPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class dropdownPage extends baseSeleniumPage {

    private final Logger logger = LogManager.getLogger(dropdownPage.class);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @FindBy(xpath = "//h3")
    private WebElement headerText;

    @FindBy(id = "dropdown")
    private WebElement dropdownSelector;

    @FindBy(xpath = "//option[@value='1']")
    private WebElement optionOne;

    @FindBy(xpath = "//option[@value='2']")
    private WebElement optionTwo;


    public dropdownPage() {
        PageFactory.initElements(driver, this);
    }

    /*Get header text*/

    public String getHeaderText() {
        logger.info("Get header text");
        return headerText.getText();
    }

    public String selectValue(String text) {

        Select select = new Select(dropdownSelector);

        switch (text.toLowerCase()) {
            case "optionone" -> {
                select.selectByVisibleText("Option 1");
                logger.info("Chose Option 1");
                return optionOne.getAttribute("selected");
            }
            case "optiontwo" -> {
                select.selectByVisibleText("Option 2");
                logger.info("Chose Option 2");
                return optionTwo.getAttribute("selected");
            }
            default -> throw new IllegalArgumentException("Invalid text: " + text);
        }
    }
}
