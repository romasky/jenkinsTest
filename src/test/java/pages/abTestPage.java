package pages;

import core.baseSeleniumPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class abTestPage extends baseSeleniumPage {
    private final Logger logger = LogManager.getLogger(abTestPage.class);

    @FindBy(xpath = "//h3")
    private WebElement abPageTitleText;

    @FindBy(xpath = "//p")
    private WebElement abPageTextBody;


    public abTestPage() {
        PageFactory.initElements(driver, this);
    }


    /*Создадим методы, которые будут получать текст */

    public String getTitleText() {
        logger.info("Get title text");
        return abPageTitleText.getText();
    }

    public String getBodyText() {
        logger.info("Get body text");
        return abPageTextBody.getText();
    }

}
