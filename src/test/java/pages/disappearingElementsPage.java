package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class disappearingElementsPage extends basicAuthPage {

    private final Logger logger = LogManager.getLogger(disappearingElementsPage.class);

    @FindBy(xpath = "//h3")
    private WebElement headerText;

    @FindBy(xpath = "//p")
    private WebElement bodyText;

    @FindAll(@FindBy(xpath = "//ul/li"))
    private List<WebElement> buttonsList;



    public disappearingElementsPage() {
        PageFactory.initElements(driver, this);
    }



    /*Check texts*/


    public String getTextFromPage(String element) {
        switch (element) {
            case "headerText":
                logger.info("Check header text");
                return headerText.getText();
            case "bodyText":
                logger.info("Check body text");
                return bodyText.getText();
            default:
                throw new IllegalArgumentException("Invalid alert type: " + element);
        }
    }

    public List<WebElement> getButtonsList() {
        logger.info("Return List with " + buttonsList.size()+" elements of buttons");
        return buttonsList;
    }

}
