package stepDefinition;

import framework.Page;
import framework.Config;
import io.cucumber.java.en.Given;

public class CommonStepDefinition {

    @Given("User navigate to WebTables page")
    public void launchBrowser(){

        Page.driver.get(Config.properties.getProperty("browser.default.url"));
    }
}
