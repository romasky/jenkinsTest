package pages;

import core.baseSeleniumPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class checkboxesPage extends baseSeleniumPage {


    private final Logger logger = LogManager.getLogger(checkboxesPage.class);

    @FindBy(xpath = "//h3")
    private WebElement headerText;

    @FindBy(xpath = "//input[1]")
    private WebElement checkboxFirst;

    @FindBy(xpath = "//input[2]")
    private WebElement checkboxSecond;

    @FindAll(@FindBy(xpath = "//input"))
    private List<WebElement> checkboxList;

    @FindBy(tagName = "form")
    private WebElement form;

    public checkboxesPage() {
        PageFactory.initElements(driver, this);
    }

    public String getHeaderText() {
        logger.info("Get header text");
        return headerText.getText();
    }

    public String getCheckboxNames(int checkbox) {
        String text = form.getText();
        String[] lines = text.split("\n");
        switch (checkbox) {
            case 0:
                logger.info("Get first checkbox: "+ lines[checkbox]);
                return lines[checkbox];
            case 1:
                logger.info("Get second checkbox: "+ lines[checkbox]);
                return lines[checkbox];
            default:
                throw new IllegalArgumentException("Invalid checkbox number: " + checkbox);
        }
    }

    public String getAttributeBeforeClick(String checkbox) {
        switch (checkbox.toLowerCase()) {
            case "first":
                return checkboxFirst.getAttribute("checked");
            case "second":
                return checkboxSecond.getAttribute("checked");
            default:
                throw new IllegalArgumentException("Invalid button color: " + checkbox);
        }
    }

    public String getAttributeAfterClick(String checkbox) {
        switch (checkbox.toLowerCase()) {
            case "first":
                checkboxFirst.click();
                return checkboxFirst.getAttribute("checked");
            case "second":
                checkboxSecond.click();
                return checkboxSecond.getAttribute("checked");
            default:
                throw new IllegalArgumentException("Invalid button color: " + checkbox);
        }
    }

    public int numberOfCheckboxes() {
        logger.info("Return List with " + checkboxList.size()+" elements");
        return checkboxList.size();
    }



}
