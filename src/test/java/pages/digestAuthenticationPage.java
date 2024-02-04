package pages;

import core.baseSeleniumPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class digestAuthenticationPage extends baseSeleniumPage {

    private final Logger logger = LogManager.getLogger(digestAuthenticationPage.class);


    @FindBy(xpath = "//h3")
    private WebElement titleAuthText;

    @FindBy(xpath = "//p")
    private WebElement bodyAuthText;

    public digestAuthenticationPage() {
        PageFactory.initElements(driver, this);
    }



    /*Check texts*/


    public String getTextFromPage(String element) {
        switch (element) {
            case "titleAuthText":
                logger.info("Check header text");
                return titleAuthText.getText();
            case "bodyAuthText":
                logger.info("Check body text");
                return bodyAuthText.getText();
            default:
                throw new IllegalArgumentException("Invalid alert type: " + element);
        }
    }
}
