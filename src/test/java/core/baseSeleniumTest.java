package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



abstract public class baseSeleniumTest {

    protected WebDriver driver;
    private final Logger logger = LogManager.getLogger(baseSeleniumTest.class);
    protected WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeDriverService service=new ChromeDriverService.Builder().withLogOutput(System.out).build();

        driver = new ChromeDriver(service); //отвечает за процесс взаимодействия с самим браузером, а хром это сам браузер
        driver.manage().window().maximize(); //Запуск драйвера на весь экран
/*        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS); //неявное ожидание, для загрузки веб-страницы
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //неявное ожидание*/


        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        baseSeleniumPage.setDriver(driver);
        logger.info("Driver is initialized");
    }


//    @AfterEach
//    public void tearDown() {
//
//
//        if (driver != null) {
//            //driver.close(); //Если вы хотите закрыть текущее окно браузера, но оставить сессию WebDriver активной (например, если вам нужно открыть новое окно или выполнить другие действия), то просто используйте метод close() без вызова quit()
//            driver.quit(); //Если вы хотите закрыть все окна браузера и завершить сеанс WebDriver, используйте только метод quit()
//        }
//
//        logger.info("Driver is quit");
//    }

}
