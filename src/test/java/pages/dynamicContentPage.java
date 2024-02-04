package pages;

import core.baseSeleniumPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class dynamicContentPage extends baseSeleniumPage {

    private final Logger logger = LogManager.getLogger(dropdownPage.class);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @FindBy(xpath = "//h3")
    private WebElement headerText;

    @FindBy(xpath = "//p[1]")
    private WebElement bodyText;

    @FindBy(xpath = "//option[@value='1']")
    private WebElement optionOne;

    @FindBy(xpath = "//option[@value='2']")
    private WebElement optionTwo;


    public dynamicContentPage() {
        PageFactory.initElements(driver, this);
    }

    /*Get texts*/

    public List<String> getText2() {
        List<String> listOfText = new ArrayList<>();
        listOfText.add(headerText.getText());
        listOfText.add(bodyText.getText());
        return listOfText;
    }



}
