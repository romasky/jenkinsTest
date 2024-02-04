package pages;

import core.baseSeleniumPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import readProperties.ConfigProvider;

public class mainPage extends baseSeleniumPage { //extends для того чтобы работал вебдрайвер

    private final Logger logger = LogManager.getLogger(mainPage.class);


    /* private final By queueList = By.id("id_queue"); //Обозначение самих локаторов, т.е. путь к самому элементу, а не их нахождение
     private final By queueList2 = By.xpath("//select[@id="id_queue"]");*/

    @FindBy(xpath = "//a[@href='/abtest']")  //a/b Test Page
    private WebElement abTestPage;                      //происходит инициализация данного элемента, когда мы к нему обращаемся

    @FindBy(xpath = "//a[@href='/add_remove_elements/']")  //Add/Remove Elements Page
    private WebElement addRemovePage;

    @FindBy(xpath = "//a[@href='/basic_auth']")  //Basic Auth (user and pass: admin)
    private WebElement basicAuthPage;

    @FindBy(xpath = "//a[@href='/broken_images']")  //Basic Auth (user and pass: admin)
    private WebElement brokenImages;

    @FindBy(xpath = "//a[@href='/challenging_dom']")  //Challenging DOM
    private WebElement challengingDOMPage;

    @FindBy(xpath = "//a[@href='/checkboxes']")  //Checkboxes
    private WebElement CheckboxesPage;

    @FindBy(xpath = "//a[@href='/context_menu']")  //context Menu
    private WebElement contextMenuPage;

    @FindBy(xpath = "//a[@href='/digest_auth']")  //digest Authentication
    private WebElement digestAuthenticationPage;

    @FindBy(xpath = "//a[@href='/disappearing_elements']")  //Disappearing Elements
    private WebElement disappearingElementsPage;

    @FindBy(xpath = "//a[@href='/drag_and_drop']")  //Drag and Drop
    private WebElement dragAndDropPage;

    @FindBy(xpath = "//a[@href='/dropdown']")  //Dropdown
    private WebElement dropdownPage;

    @FindBy(xpath = "//a[@href='/dynamic_content']")  //Dynamic Content
    private WebElement dynamicContentPage;




    @FindBy(xpath = "//a[@href='/javascript_alerts']")  //JavaScript Alerts page
    private WebElement jsAlertsPage;


    public mainPage() {
        driver.get(ConfigProvider.URL);
        PageFactory.initElements(driver, this);
        //PageFactory в Selenium упрощает и автоматизирует инициализацию элементов страницы
        // и обеспечивает удобное взаимодействие с ними в тестовых сценариях.
    }


    /*необходимо открыть страницу abTestPage*/
    public abTestPage openAbTestPage(){
        abTestPage.click();
        logger.info("A/B Testing page is open");
        return new abTestPage();
    }


    /*необходимо открыть страницу addRemovePage*/
    public addRemovePage openaddRemovePage(){
        addRemovePage.click();
        logger.info("Add/Remove Elements page is open");
        return new addRemovePage();
    }


    /*необходимо открыть страницу openbasicAuthPage*/
    public basicAuthPage openbasicAuthPage(){
        HasAuthentication authentication = (HasAuthentication) driver;
        authentication.register(()->new UsernameAndPassword(ConfigProvider.USER_LOGIN,ConfigProvider.USER_PASS));
        driver.get(ConfigProvider.URL+ConfigProvider.BASIC_AUTH);
        logger.info("Basic Auth page is open");
        return new basicAuthPage();
    }


    /*необходимо открыть страницу BrokenImagesPage*/
    public brokenImagesPage openBrokenImagesPage(){
        brokenImages.click();
        logger.info("Broken Images page is open");
        return new brokenImagesPage();
    }


    /*необходимо открыть страницу ChallengingDOMPage*/
    public challengingDOMPage openChallengingDOMPage(){
        challengingDOMPage.click();
        logger.info("Challenging DOM page is open");
        return new challengingDOMPage();
    }


    /*необходимо открыть страницу CheckboxesPage*/
    public checkboxesPage openCheckboxesPage(){
        CheckboxesPage.click();
        logger.info("Checkboxes page is open");
        return new checkboxesPage();
    }


    /*необходимо открыть страницу ContextMenuPage*/
    public contextMenuPage openContextMenuPage(){
        contextMenuPage.click();
        logger.info("Context Menu page is open");
        return new contextMenuPage();
    }


    /*необходимо открыть страницу ContextMenuPage*/
    public digestAuthenticationPage digestAuthenticationPage(){
        HasAuthentication authentication = (HasAuthentication) driver;
        authentication.register(()->new UsernameAndPassword(ConfigProvider.USER_LOGIN,ConfigProvider.USER_PASS));
        driver.get(ConfigProvider.URL+ConfigProvider.DIGEST_AUTH);
        logger.info("Digest Authentication page is open");
        return new digestAuthenticationPage();
    }


    /*необходимо открыть страницу disappearingElementsPage*/
    public disappearingElementsPage opendisappearingElementsPage(){
        disappearingElementsPage.click();
        logger.info("Disappearing Elements page is open");
        return new disappearingElementsPage();
    }


    /*необходимо открыть страницу dragAndDropPage*/
    public dragAndDropPage opendragAndDropPage(){
        dragAndDropPage.click();
        logger.info("Drag and Drop page is open");
        return new dragAndDropPage();
    }


    /*необходимо открыть страницу dropdownPage*/
    public dropdownPage opendropdownPage(){
        dropdownPage.click();
        logger.info("Dropdown page is open");
        return new dropdownPage();
    }


    /*необходимо открыть страницу dropdownPage*/
    public dynamicContentPage opendynamicContentPage(){
        dynamicContentPage.click();
        logger.info("Dynamic Content page is open");
        return new dynamicContentPage();
    }






    //необходимо открыть страницу javaScriptAlertsPage
    public javaScriptAlertsPage openJSAlertsPage(){
        jsAlertsPage.click();
        logger.info("JavaScript Alerts page is open");
        return new javaScriptAlertsPage();
    }


}
