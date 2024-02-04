package pages;

import core.baseSeleniumPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class brokenImagesPage extends baseSeleniumPage {

    private final Logger logger = LogManager.getLogger(brokenImagesPage.class);

    @FindAll(@FindBy(tagName = "img"))
    private List<WebElement> imageElements;

    public brokenImagesPage() {
        PageFactory.initElements(driver, this);
    }


    public List<WebElement> getImagesLinks() {
        logger.info("Return List with " + imageElements.size()+" elements");
       return imageElements;
    }

}
