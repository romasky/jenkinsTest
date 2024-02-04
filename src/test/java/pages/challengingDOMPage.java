package pages;

import core.baseSeleniumPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class challengingDOMPage extends baseSeleniumPage {

    private final Logger logger = LogManager.getLogger(challengingDOMPage.class);

    @FindBy(xpath = "//h3")
    private WebElement headerText;

    @FindBy(xpath = "//p")
    private WebElement bodyText;

    @FindAll(@FindBy(xpath = "//div[contains(@class, 'l')]/a"))
    private List<WebElement> buttonElements;

    @FindBy(xpath = "//div[@class='large-2 columns']/a[1]")
    private WebElement blueButton;

    @FindBy(xpath = "//div[@class='large-2 columns']/a[2]")
    private WebElement redButton;

    @FindBy(xpath = "//div[@class='large-2 columns']/a[3]")
    private WebElement greenButton;

    @FindAll(@FindBy(xpath = "//thead//th"))
    private List<WebElement> tableHeaders;

    @FindAll(@FindBy(xpath = "//div[@class=\"large-10 columns\"]//tbody/tr"))
    private List<WebElement> tableRows;

    @FindAll(@FindBy(xpath = "//td/a[1]"))
    private List<WebElement> editButtons;

    @FindAll(@FindBy(xpath = "//td/a[2]"))
    private List<WebElement> deleteButtons;

    @FindBy(xpath = "//div[@id=\"content\"]/script")
    private WebElement scriptContent;

    @FindBy(xpath = "//canvas")
    private WebElement canvasData;



    public challengingDOMPage() {
        PageFactory.initElements(driver, this);
    }


    public int getListOfButtonsSize() {
        logger.info("Return List with " + buttonElements.size()+" elements");
        return buttonElements.size();
    }

    public String getHeaderText() {
        return headerText.getText();
    }

    public String getBodyText() {
        return bodyText.getText();
    }

    public Boolean checkButtonAttributeIdIsDifferent(String color) {
        String tempIdStorage;
        switch (color.toLowerCase()) {
            case "blue":
                tempIdStorage = blueButton.getAttribute("id");
                blueButton.click();
                logger.info("Blue button clicked");
                return !tempIdStorage.equals(blueButton.getAttribute("id"));
            case "red":
                tempIdStorage = redButton.getAttribute("id");
                redButton.click();
                logger.info("Red button clicked");
                return !tempIdStorage.equals(redButton.getAttribute("id"));
            case "green":
                tempIdStorage = greenButton.getAttribute("id");
                greenButton.click();
                logger.info("Green button clicked");
                return !tempIdStorage.equals(greenButton.getAttribute("id"));
            default:
                throw new IllegalArgumentException("Invalid button color: " + color);
        }
    }

    public List<String> getTableHeadersList() {
        List<String> headersList  = new ArrayList<>();;
        if(tableHeaders != null && !tableHeaders.isEmpty()) {
        for (WebElement s: tableHeaders
             ) {
            headersList.add(s.getText());
        }
        }
        return headersList;
    }

    public int getListOfTableRowsSize() {
        logger.info("Return List with " + tableRows.size()+" elements");
        return tableRows.size();
    }

    public List<String> getTableCellsItemsList() {
        List<String> rowList  = new ArrayList<>();
        for (WebElement row : tableRows) {
            List<WebElement> columns = row.findElements(By.xpath(".//td"));

            for (int i = 0; i < columns.size() - 1; i++) {
                String cellText = columns.get(i).getText();
                rowList.add(cellText);
                logger.info(cellText);
            }
        }
        return rowList;
    }

    public String checkButtonEdit() {
        for (WebElement el: editButtons
             ) {
            el.click();
            logger.info("Click on 'Edit' button");
        }
        return driver.getCurrentUrl();
    }

    public String checkDeleteButtonEdit() {
        for (WebElement del: deleteButtons
        ) {
            del.click();
            logger.info("Click on 'Delete' button");
        }
        return driver.getCurrentUrl();
    }

    public Boolean checkNumberIsDifferentAfterRefresh() {
        Pattern pattern = Pattern.compile("Answer: (\\d+)");
        Matcher matcher = pattern.matcher(scriptContent.getAttribute("innerHTML"));
        if (!matcher.find()) {
            logger.info("Number not found.");
            return false;
        }
        String oldNumber = matcher.group(1);
        logger.info("First number is " + oldNumber);

        driver.navigate().refresh();
        matcher = pattern.matcher(scriptContent.getAttribute("innerHTML"));
        if (!matcher.find()) {
            logger.info("New number not found.");
            return false;
        }
        String newNumber = matcher.group(1);
        logger.info("New number is " + newNumber);
        boolean isNumberDifferent = !oldNumber.equals(newNumber);
        logger.info("Number has " + (isNumberDifferent ? "changed" : "not changed") + " after refresh.");

        return isNumberDifferent;
    }

    public String getCanvasAttribute(String attribute) {
        switch (attribute) {
            case "width":
                String width = canvasData.getAttribute("width");
                logger.info("Canvas width is " + width);
                return width;
            case "height":
                String height = canvasData.getAttribute("height");
                logger.info("Canvas height is " + height);
                return height;
            case "style":
                String style = canvasData.getAttribute("style");
                logger.info("Canvas style is " + style);
                return style;
            default:
                logger.info("Unsupported attribute: " + attribute);
                throw new IllegalArgumentException("Unsupported attribute: " + attribute);
        }
    }
}
