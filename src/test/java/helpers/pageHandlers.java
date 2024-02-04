package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

public class pageHandlers {

    private static final Logger logger = LogManager.getLogger(pageHandlers.class);

    public static String getPageText(WebElement element) {
        return element.getText();
    }



}
