package pages;

import core.baseSeleniumPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class addRemovePage extends baseSeleniumPage {

    private final Logger logger = LogManager.getLogger(addRemovePage.class);

    Random random = new Random();
    public int n = random.nextInt(10) + 1;

    @FindBy(xpath = "//button[@onclick='addElement()']")
    private WebElement addElementButton;

    @FindAll(@FindBy(xpath = "//div[@id='elements']/button"))
    private List<WebElement> deleteElements;


    public addRemovePage() {
        PageFactory.initElements(driver, this);
    }

    /*Создадим методы, которые будут добавлять и удалять элементы */

    public void clickAddElementButton() {
        logger.info("N is :"+n);
        for (int i = 0; i < n; i++) {
            addElementButton.click();
        }
    }

    public int deleteButtonAppears() {
        logger.info("N is :"+n);
        for (int i = 0; i < n; i++) {
            addElementButton.click();
        }
        for (WebElement element : deleteElements) {
            element.click();
        }
        return deleteElements.size();
    }

    public int countDeleteButtons() {
        return deleteElements.size();
    }






}
