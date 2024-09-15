package framework;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.time.Duration;

import static framework.Config.properties;
public class BrowserFactory {

    private BrowserFactory() {
    }

    /**
     * Method to get the chrome driver object
     * @return WebDriver
     */
    private WebDriver initializeChrome() {
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        options.setImplicitWaitTimeout(Duration.ofSeconds(Integer.parseInt(properties.getProperty("browser.timeout.implicit"))));
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
        return new ChromeDriver(options);
    }

    /**
     * Method to get the firefox driver object
     * @return WebDriver
     */
    private WebDriver initializeFirefox() {
        FirefoxOptions options = new FirefoxOptions();
        options.setAcceptInsecureCerts(true);
        options.setImplicitWaitTimeout(Duration.ofSeconds(Integer.parseInt(properties.getProperty("browser.timeout.implicit"))));
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
        return new FirefoxDriver(options);
    }

    /**
     * Method to get the safari driver object
     * @return WebDriver
     */
    private WebDriver initializeSafari() {
        SafariOptions options = new SafariOptions();
        options.setAcceptInsecureCerts(true);
        options.setImplicitWaitTimeout(Duration.ofSeconds(Integer.parseInt(properties.getProperty("browser.timeout.implicit"))));
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
        return new SafariDriver(options);
    }

    /**
     * Method to get the edge driver object
     * @return WebDriver
     */
    private WebDriver initializeEdge() {
        EdgeOptions options = new EdgeOptions();
        options.setAcceptInsecureCerts(true);
        options.setImplicitWaitTimeout(Duration.ofSeconds(Integer.parseInt(properties.getProperty("browser.timeout.implicit"))));
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
        return new EdgeDriver(options);
    }

    /**
     * Method to get the web driver object
     * @return WebDriver
     */
    public static WebDriver getBrowser() {
        BrowserFactory factory = new BrowserFactory();
        WebDriver driver = switch (Config.properties.getProperty("browser.type", "chrome").toLowerCase()) {
            case "firefox" -> factory.initializeFirefox();
            case "safari" -> factory.initializeSafari();
            case "edge" -> factory.initializeEdge();
            default -> factory.initializeChrome();
        };
        driver.manage().window().maximize();
        driver.get(properties.getProperty("browser.default.url"));
        return driver;
    }
}
