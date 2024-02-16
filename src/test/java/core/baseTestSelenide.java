package core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.manager.SeleniumManager;

public class baseTestSelenide {

    /**
     * Selenide init
     */
    @Step("Инициализация Selenide")
    public void setUp() {

        SeleniumManager seleniumManager = SeleniumManager.getInstance();


        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
    }

    /**
     * Execute method before test start
     */

    @BeforeEach
    public void init() {
        setUp();
    }

    /**
     * Execute method after close each test
     */

    @AfterEach
    public void tearDown(){
        Selenide.closeWebDriver();
    }
}
