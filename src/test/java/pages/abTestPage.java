package pages;

import core.baseSeleniumPage;
import io.qameta.allure.Step;
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



    @Step("Собираем тайтл со страницы")
    public String getTitleText() {
        logger.info("Get title text");
        return abPageTitleText.getText();
    }
    @Step("Собираем текст со страницы")
    public String getBodyText() {
        logger.info("Get body text");
        return abPageTextBody.getText();
    }

}
