package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class alertHelpers {

    private static final Logger logger = LogManager.getLogger(alertHelpers.class);

    public static Alert alert=null;

    public static void alertHandler(WebDriver driver) {  // Переключаемся на алерт
        try {
            alert = driver.switchTo().alert();
            logger.info("driver switched to alert");
        } catch (NoAlertPresentException e) {
            // Обработка случая, когда алерт отсутствует
            logger.error("Alert is null");
        }
    }

    public static void acceptAlert(WebDriver driver) {   // Принимаем алерт
        try {
            alert = driver.switchTo().alert();
            logger.info("acceptAlert - driver switched to alert");
            alert.accept();
            logger.info("acceptAlert - alert accepted");
        }catch (NoAlertPresentException e) {
            // Обработка ситуации, когда алерт не найден
            logger.error("acceptAlert - alert not found: " + e.getMessage());
        } catch (WebDriverException e) {
            // Обработка других исключений WebDriver
            logger.error("acceptAlert - error appeared - WebDriver: " + e.getMessage());
        } finally {
            driver.switchTo().defaultContent();
            logger.info("acceptAlert - Successfully switched to default content");
        }
    }

    public static void dismissAlert(WebDriver driver) {  // Отклоняем алерт
        try {
            alert = driver.switchTo().alert();
            logger.info("dismissAlert - driver switched to alert");
            alert.dismiss();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Укажите максимальное время ожидания по вашему усмотрению
            wait.until(ExpectedConditions.not(ExpectedConditions.alertIsPresent()));
            logger.info("dismissAlert - alert dismissed");

        } catch (NoAlertPresentException e) {
            // Обработка ситуации, когда алерт не найден
            logger.error("dismissAlert - alert not found: " + e.getMessage());
        } catch (WebDriverException e) {
            // Обработка других исключений WebDriver
            logger.error("dismissAlert - error appeared - WebDriver: " + e.getMessage());
        } finally {
            driver.switchTo().defaultContent();
            logger.info("dismissAlert - Successfully switched to default content");
        }
    }

    public static String getAlertText(WebDriver driver) {   // Получаем текст из алерта
        return driver.switchTo().alert().getText();
    }

    public static void sendKeysToAlert(WebDriver driver, String text) {   // Вводим текст в поле ввода алерта
        try {
            alert = driver.switchTo().alert();
            logger.info("sendKeysToAlert - driver switched to alert");
            alert.sendKeys(text);
            logger.info("sendKeysToAlert - sent text");
        } catch (NoAlertPresentException e) {
            // Обработка ситуации, когда алерт не найден
            logger.error("sendKeysToAlert - alert not found: " + e.getMessage());
        } catch (WebDriverException e) {
            // Обработка других исключений WebDriver
            logger.error("sendKeysToAlert - error appeared - WebDriver: " + e.getMessage());
        }
    }

}
