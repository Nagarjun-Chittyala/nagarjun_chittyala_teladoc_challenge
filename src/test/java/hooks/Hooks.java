package hooks;

import framework.*;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

import java.util.Objects;

import static framework.Page.driver;

public class Hooks {
    private static final Config config = new Config();

    @BeforeAll
    public static void setUp(){
        config.loadProperties();
        config.loadLocators();

        driver = BrowserFactory.getBrowser();
        Page.actions = new BrowserActions(driver);
        Page.assertionHelper = new AssertionHelper();
    }

    @AfterAll
    public static void cleanUp(){
        if(Objects.nonNull(driver)){
//            driver.close();
            driver.quit();
        }
    }
}
