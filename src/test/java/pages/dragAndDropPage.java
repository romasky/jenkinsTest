package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class dragAndDropPage extends basicAuthPage {
    private final Logger logger = LogManager.getLogger(dragAndDropPage.class);

    @FindBy(xpath = "//h3")
    private WebElement headerText;

    @FindBy(xpath = "//div[@id='column-a']")
    private WebElement boxAToDrag;

    @FindBy(xpath = "//div[@id='column-b']")
    private WebElement boxBToDrag;

    @FindBy(xpath = "//div[@id='column-a']/header")
    private WebElement headerABox;

    @FindBy(xpath = "//div[@id='column-b']/header")
    private WebElement headerBBox;


    public dragAndDropPage() {
        PageFactory.initElements(driver, this);
    }

    /*Get header text*/

    public String getHeaderText() {
        logger.info("Get header text");
        return headerText.getText();
    }

    public String getBoxAText() {
        logger.info("Get title text");
        return headerABox.getText();
    }
    public String getBoxBText() {
        logger.info("Get title text");
        return headerBBox.getText();
    }


    /*Drag A to B*/

    public void dragAndDropAToB() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(boxAToDrag,boxBToDrag).perform();
    }
}
