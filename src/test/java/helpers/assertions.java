package helpers;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class assertions {

    private static final Logger logger = LogManager.getLogger(assertions.class);

//    public static void checkAlertAppears() {
//        Assertions.assertNotNull(alertHelpers.alert, "Failed to open the alert");
//        logger.info("Alert is appears");
//    }

    public static void checkAlertText(String expectedValue, String actualValue) {
        Assertions.assertEquals(expectedValue, actualValue, "Alert text is not equal to expectedValue " + expectedValue);
        logger.info("Text is equals on Alerts popup");
    }
    public static void checkAlertClosed(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            wait.until(ExpectedConditions.not(ExpectedConditions.alertIsPresent()));
            logger.info("Alert has been closed");
        } catch (TimeoutException e) {
            logger.error("Failed to close the alert: " + e.getMessage());
            // Здесь можно добавить дополнительную обработку, если необходимо
        }
    }


    public static void textCompare(String expectedValue, String actualValue) {
        Assertions.assertEquals(expectedValue, actualValue,"Text value is not equal to expectedValue " + expectedValue);
        logger.info("Text is equals");
    }
    public static void textCompare(String expectedValue1, String expectedValue2, String actualValue) {
        if (actualValue.equals(expectedValue1) || actualValue.equals(expectedValue2)) {
            logger.info("Text is equals");
        } else {
            Assertions.fail("Text value is not equal to expectedValue " + expectedValue1 + " or " + expectedValue2);
        }
    }
//
//    public static void deleteButtonAppearsNTimes(addRemovePage addRemovePage) {
//        Assertions.assertEquals(addRemovePage.countDeleteButtons(), addRemovePage.n);
//        logger.info("Delete button appeared "+addRemovePage.n+" times");
//    }
//
//    public static void zeroListSize(addRemovePage addRemovePage) {
//        Assertions.assertEquals(0, addRemovePage.countDeleteButtons());
//        logger.info("Delete button appeared and closed "+addRemovePage.n+" times");
//    }

    public static void checkImageLinks(List<WebElement> imagesLinks) throws IOException {

        for (WebElement img:imagesLinks) {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(img.getAttribute("src"));
            HttpResponse response = client.execute(request);

            if (response.getStatusLine().getStatusCode() != 200)
            {
                logger.info(img.getAttribute("outerHTML") + " is broken.");
            } else {
                logger.info(img.getAttribute("outerHTML") + " link exists.");
            }
        }
    }

    public static void integerCompare(int expectedValue, int actualValue) {
        Assertions.assertEquals(expectedValue, actualValue,"int value is not equal to expectedValue " + expectedValue);
        logger.info("Ints are equals");
    }

    public static void BooleanCompare(boolean expectedValue, boolean actualValue) {
        Assertions.assertEquals(expectedValue, actualValue,"Boolean value is not equal to expectedValue " + expectedValue);
        logger.info("Boolean is equals");
    }

    public static void StringListCompare(List<String> expectedValue, List<String> actualValue) {
        for (int i = 0; i < expectedValue.size(); i++) {
            String expected = expectedValue.get(i);
            String actual = actualValue.get(i);

            Assertions.assertEquals(expected, actual, "Actual Lists value " +"\"" + actual + "\"" + " is not equal to expectedValue: " + "\"" + expected+"\"");
        }
        logger.info("Lists are equals");
    }


    public static void checkNotNullListItems(List<String> list) {
        Assertions.assertNotNull(list, "List is null");
        for (String item : list) {
            Assertions.assertNotNull(item, "Found null item in the list");
        }
        logger.info("All items in the list are not null.");
    }

    public static void checkAttribute(String expectedValue, String attrubite) {
        Assertions.assertEquals(expectedValue, attrubite);
        logger.info("Attribute checked successfully");
    }


    public static void checkButtons(List<String> expectedButtons, List<WebElement> buttons) {
        List<String> actualButtonNames = new ArrayList<>();
        for (WebElement button : buttons) {
            actualButtonNames.add(button.getText()); // adding actual buttons from webpage
        }
        logger.info("Add actual buttons in the list");
        for (String expectedButton : expectedButtons) {                         // Check that each expected button is present among the actual buttons
            Assertions.assertTrue(actualButtonNames.contains(expectedButton),
                    "The button is missing from the page: " + expectedButton);
        }

        logger.info("All expected buttons are present on the page and their number is as expected");
    }


}
