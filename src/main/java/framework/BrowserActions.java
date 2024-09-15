package framework;

import constants.SelectStrategy;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * @author Nagarjun chittyala
 */
public class BrowserActions {
    private final WebDriverWait wait;
    private final LocatorBuilder locatorBuilder;

    public BrowserActions(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.locatorBuilder = new LocatorBuilder();
    }

    /**
     * Method to get the web-element
     *
     * @param pageName   Page Name
     * @param identifier unique identifier to get the locator
     * @return WebElement
     */
    public WebElement getElement(String pageName, String identifier) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(
                locatorBuilder.getLocator(pageName, identifier)
        ));
    }

    /**
     * Method to get the web-element
     *
     * @param pageName    Page Name
     * @param identifier  unique identifier to get the locator
     * @param formatValue value to be replaced in the locator
     * @return WebElement
     */
    public WebElement getElement(String pageName, String identifier, String formatValue) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(
                locatorBuilder.getLocator(pageName, identifier, formatValue)
        ));
    }

    /**
     * Method to get the list of web-elements
     *
     * @param pageName   Page Name
     * @param identifier unique identifier to get the locator
     * @return List of WebElement
     */
    public List<WebElement> getElements(String pageName, String identifier) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                locatorBuilder.getLocator(pageName, identifier)
        ));
    }

    /**
     * Method to get the list of web-elements
     *
     * @param pageName    Page Name
     * @param identifier  unique identifier to get the locator
     * @param formatValue value to be replaced in the locator
     * @return List of WebElement
     */
    public List<WebElement> getElements(String pageName, String identifier, String formatValue) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                locatorBuilder.getLocator(pageName, identifier, formatValue)
        ));
    }

    /**
     * Method to click on a web element
     *
     * @param pageName   Page Name
     * @param identifier unique identifier to get the locator
     */
    public void click(String pageName, String identifier) {
        try {
            WebElement element = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            locatorBuilder.getLocator(pageName, identifier)
                    ));
            element.click();
        } catch (WebDriverException e) {
            System.err.printf("Unable to click on the %s element%n", identifier);
        }
    }

    /**
     * Method to click on a web element
     *
     * @param pageName    Page Name
     * @param identifier  unique identifier to get the locator
     * @param formatValue value to be replaced in the locator
     */
    public void click(String pageName, String identifier, String formatValue) {
        try {
            WebElement element = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            locatorBuilder.getLocator(pageName, identifier, formatValue)
                    ));
            element.click();
        } catch (WebDriverException e) {
            System.err.printf("Unable to click on the %s element%n", identifier);
        }
    }

    /**
     * Method to enter text in a web element
     *
     * @param pageName   Page Name
     * @param identifier unique identifier to get the locator
     * @param value      Value to be entered
     */
    public void enterText(String pageName, String identifier, String value) {
        try {
            WebElement element = getElement(pageName, identifier);
            element.sendKeys(value);
        } catch (WebDriverException e) {
            System.err.printf("Unable to enter text on the %s field%n", identifier);
        }
    }

    /**
     * Method to enter text in a web element
     *
     * @param pageName    Page Name
     * @param identifier  unique identifier to get the locator
     * @param value       Value to be entered
     * @param formatValue value to be replaced in the locator
     */
    public void enterText(String pageName, String identifier, String value, String formatValue) {
        try {
            WebElement element = getElement(pageName, identifier, formatValue);
            element.sendKeys(value);
        } catch (WebDriverException e) {
            System.err.printf("Unable to enter text on the %s field%n", identifier);
        }
    }

    /**
     * Method to click on a web element
     *
     * @param pageName   Page Name
     * @param identifier unique identifier to get the locator
     * @param option     Dropdown option to be selected
     * @param strategy   Dropdown select strategy
     */
    public void select(String pageName, String identifier, String option, SelectStrategy strategy) {
        try {
            Select select = new Select(getElement(pageName, identifier));
            switch (strategy) {
                case value -> select.selectByValue(option);
                case index -> select.selectByIndex(Integer.parseInt(option));
                default -> select.selectByVisibleText(option);
            }
        } catch (WebDriverException e) {
            System.err.printf("Unable to select option from the %s dropdown %n", identifier);
        }
    }

    /**
     * Method to get the text from the web element
     *
     * @param pageName   Page Name
     * @param identifier unique identifier to get the locator
     * @return String
     */
    public String getText(String pageName, String identifier) {
        try {
            WebElement element = getElement(pageName, identifier);
            return element.getText();
        } catch (WebDriverException e) {
            System.err.printf("Unable to enter text on the %s field%n", identifier);
            return "";
        }
    }

    /**
     * Method to get the text from the web element
     *
     * @param pageName    Page Name
     * @param identifier  unique identifier to get the locator
     * @param formatValue value to be replaced in the locator
     * @return String
     */
    public String getText(String pageName, String identifier, String formatValue) {
        try {
            WebElement element = getElement(pageName, identifier, formatValue);
            return element.getText();
        } catch (WebDriverException e) {
            System.err.printf("Unable to enter text on the %s field%n", identifier);
            return "";
        }
    }

    /**
     * Method to get the presence of a web element
     *
     * @param pageName   Page Name
     * @param identifier unique identifier to get the locator
     * @return Boolean
     */
    public boolean isPresent(String pageName, String identifier) {
        try {
            WebElement element = getElement(pageName, identifier);
            Dimension dimension = element.getSize();
            return element.isDisplayed() && (dimension.height == 0 || dimension.width == 0);
        } catch (WebDriverException e) {
            System.err.printf("Unable to check the present of the %s field%n", identifier);
            return false;
        }
    }

    /**
     * Method to get the presence of a web element
     *
     * @param pageName    Page Name
     * @param identifier  unique identifier to get the locator
     * @param formatValue value to be replaced in the locator
     * @return Boolean
     */
    public boolean isPresent(String pageName, String identifier, String formatValue) {
        try {
            WebElement element = getElement(pageName, identifier, formatValue);
            Dimension dimension = element.getSize();
            return element.isDisplayed() && (dimension.height == 0 || dimension.width == 0);
        } catch (WebDriverException e) {
            System.err.printf("Unable to check the present of the %s field%n", identifier);
            return false;
        }
    }

}
