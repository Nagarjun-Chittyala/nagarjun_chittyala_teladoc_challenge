package framework;

import POJO.Locator;
import POJO.PageLocator;
import constants.LocatorType;
import org.openqa.selenium.By;

import static framework.Config.locatorRepository;
public class LocatorBuilder {

    private PageLocator getPage(String pageName){
        PageLocator[] pages = locatorRepository.getPages();
        for(PageLocator page: pages){
            if(page.getPage().equals(pageName)){
                return page;
            }
        }
        return null;
    }

    private Locator getLocator(Locator[] locators, String identifier){
        for (Locator locator: locators){
            if(locator.getIdentifier().equals(identifier)){
                return locator;
            }
        }
        return null;
    }

    /**
     * Method to get the locator based on page name and identifier
     * @param pageName page name
     * @param identifier unique identifier of the locator
     * @return By object
     */
    public By getLocator(String pageName, String identifier){
        PageLocator page = getPage(pageName);
        Locator locator = getLocator(page.getLocators(), identifier);
        return switch (locator.getType()){
            case LocatorType.ID -> By.id(locator.getLocator());
            case LocatorType.NAME -> By.name(locator.getLocator());
            case LocatorType.CLASS_NAME -> By.className(locator.getLocator());
            case LocatorType.CSS_SELECTOR -> By.cssSelector(locator.getLocator());
            case LocatorType.LINK_TEXT -> By.linkText(locator.getLocator());
            case LocatorType.PARTIAL_LINK_TEXT -> By.partialLinkText(locator.getLocator());
            case LocatorType.TAG_NAME -> By.tagName(locator.getLocator());
            default -> By.xpath(locator.getLocator());
        };
    }

    /**
     * Method to get the locator based on page name and identifier
     * @param pageName page name
     * @param identifier unique identifier of the locator
     * @param formatValue value to be replaced in the locator value
     * @return By object
     */
    public By getLocator(String pageName, String identifier, String formatValue){
        PageLocator page = getPage(pageName);
        Locator locator = getLocator(page.getLocators(), identifier);
        return switch (locator.getType()){
            case LocatorType.ID -> By.id(locator.getLocator().formatted(formatValue));
            case LocatorType.NAME -> By.name(locator.getLocator().formatted(formatValue));
            case LocatorType.CLASS_NAME -> By.className(locator.getLocator().formatted(formatValue));
            case LocatorType.CSS_SELECTOR -> By.cssSelector(locator.getLocator().formatted(formatValue));
            case LocatorType.LINK_TEXT -> By.linkText(locator.getLocator().formatted(formatValue));
            case LocatorType.PARTIAL_LINK_TEXT -> By.partialLinkText(locator.getLocator().formatted(formatValue));
            case LocatorType.TAG_NAME -> By.tagName(locator.getLocator().formatted(formatValue));
            default -> By.xpath(locator.getLocator().formatted(formatValue));
        };
    }
}
