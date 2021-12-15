package configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BrowserEnvironment {

    Logger logger = LoggerFactory.getLogger(BrowserEnvironment.class);
    private String browserName = "chrome";
    private boolean headlessBrowser;
    private int webElementTimeOut;
    private int webBrowserImplicitTimeOut;
    private boolean attachScreenShot;
    private WebDriver driver;
    private YamlReader yamlReader;

    public BrowserEnvironment() {
//        this.headlessBrowser = false;
//        this.webElementTimeOut = 10;
//        this.webBrowserImplicitTimeOut = 5;
//        this.attachScreenShot = true;
        this.browserName = GlobalProperties.BROWSER.isSpecified() ? GlobalProperties.BROWSER.getValue() : this.browserName;
        // BrowserType.setBrowser(this.browserName.toUpperCase());
        //this.setEnvironmentName(PropertyStore.BROWSER_ENVIRONMENT.isSpecified() ? PropertyStore.BROWSER_ENVIRONMENT.getValue().toUpperCase() : "LOCAL");
//        this.initBrowserSettings();
    }


    public String getBrowserName() {
        return this.browserName;
    }


    public boolean isHeadlessBrowser() {
        return this.headlessBrowser;
    }

    public int getWebBrowserImplicitTimeOut() {
        return this.webBrowserImplicitTimeOut;
    }


    public boolean isAttachScreenShotEnabled() {
        return this.attachScreenShot;
    }

    public int getWebElementTimeOut() {
        return this.webElementTimeOut;
    }

    private void initBrowserSettings() {
//        this.webElementTimeOut = PropertiesStore.BROWSER_WEBELEMENT_TIMEOUT.isSpecified() ? PropertiesStore.BROWSER_WEBELEMENT_TIMEOUT.getIntValue() : this.webElementTimeOut;
//        this.webBrowserImplicitTimeOut = PropertiesStore.BROWSER_IMPLICIT_TIMEOUT.isSpecified() ? PropertiesStore.BROWSER_IMPLICIT_TIMEOUT.getIntValue() : this.webBrowserImplicitTimeOut;
//        this.attachScreenShot = PropertiesStore.BROWSER_ATTACH_SCREENSHOT.isSpecified() ? PropertiesStore.BROWSER_ATTACH_SCREENSHOT.getBoolean() : this.attachScreenShot;
//        this.headlessBrowser = PropertiesStore.BROWSER_HEADLESS.getBoolean();
    }

    public WebDriver getDriver() {
        //listener
        switch (this.browserName) {
            case "chrome":
                ChromeOptions optionsChrome = new ChromeOptions();
                WebDriverManager.chromedriver().setup();
                optionsChrome.addArguments("start-maximized");
                driver = new ChromeDriver(optionsChrome);          //listener
                /*yamlReader = new YamlReader();
                String webUrl = yamlReader.getConfig().getEnvironments().getEnvironment().getWebUrl();      */
                String webUrl= System.getProperty("webUrl");
                driver.get(webUrl);
                logger.info("Opened website at webUrl: {}", webUrl);
                break;
            case "firefox":
                FirefoxOptions optionsFirefox = new FirefoxOptions();
                WebDriverManager.firefoxdriver().setup();
                optionsFirefox.addArguments("start-maximized");
                driver = new FirefoxDriver(optionsFirefox);          //listener
                // driver = new EventFiringWebDriver(webdriver);         // listener
//                webListener = new WebListener();                     //listener
//                driver.register(webListener);                         //listener
//                webdriver.get(System.getProperty("appUrl"));
                /*yamlReader = new YamlReader();
                String webUrl1 = yamlReader.getConfig().getEnvironments().getEnvironment().getWebUrl();*/
                String webUrl1 = System.getProperty("webUrl");
                driver.get(webUrl1);
                logger.info("Opened website at webUrl: {}", webUrl1);
                break;
            default:
                InternetExplorerOptions optionsDefault = new InternetExplorerOptions();
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver(optionsDefault);
//                driver = new EventFiringWebDriver(webdriver);         // listener
//                webListener = new WebListener();                     //listener
//                driver.register(webListener);                         //listener
//                webdriver.get(System.getProperty("appUrl"));
                /*yamlReader = new YamlReader();
                String webUrl2 = yamlReader.getConfig().getEnvironments().getEnvironment().getWebUrl();*/
                String webUrl2 = System.getProperty("webUrl");
                driver.get(webUrl2);
                logger.info("Opened website at webUrl: {}", webUrl2);
        }

        return this.driver;
    }

    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }


    public void setHeadlessBrowser(boolean headlessBrowser) {
        this.headlessBrowser = headlessBrowser;
    }

    public void setWebElementTimeOut(int webElementTimeOut) {
        this.webElementTimeOut = webElementTimeOut;
    }

    public void setWebBrowserImplicitTimeOut(int webBrowserImplicitTimeOut) {
        this.webBrowserImplicitTimeOut = webBrowserImplicitTimeOut;
    }

    public void setAttachScreenShot(boolean attachScreenShot) {
        this.attachScreenShot = attachScreenShot;
    }


}


