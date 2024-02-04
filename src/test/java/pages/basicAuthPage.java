package pages;

import core.baseSeleniumPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class basicAuthPage extends baseSeleniumPage {
    private final Logger logger = LogManager.getLogger(basicAuthPage.class);

    @FindBy(xpath = "//body")
    private WebElement bodyNotAuthText;

    @FindBy(xpath = "//h3")
    private WebElement titleAuthText;

    @FindBy(xpath = "//p")
    private WebElement bodyAuthText;

    public basicAuthPage() {
        PageFactory.initElements(driver, this);
    }



    /*Check text in auth text*/


    public String getTextFromPage(String element) {
        switch (element) {
            case "bodyNotAuthText":
                logger.info("Return body Not Auth Text");
                return bodyNotAuthText.getText();
            case "titleAuthText":
                logger.info("Return title Auth Text");
                return titleAuthText.getText();
            case "bodyAuthText":
                logger.info("Return body Auth Text");
                return bodyAuthText.getText();
            default:
                throw new IllegalArgumentException("Invalid alert type: " + element);
        }
    }
}
