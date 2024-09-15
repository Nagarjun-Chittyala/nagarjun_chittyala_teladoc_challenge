package framework;

import POJO.LocatorRepository;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Class for utility functions
 */
public class Config {
    public static Properties properties;
    public static LocatorRepository locatorRepository;

    private final String RESOURCE_PATH = "src/main/resources";
    private final String FILE_PATH = "%s/%s";
    private final String AUTOMATION_PROPERTIES_FILE = "automation.properties";
    private final String LOCATOR_REPOSITORY_JSON = "locatorRepository.json";

    /**
     * Method to load the automation.properties into the Properties object
     */
    public void loadProperties() {
        try {
            properties = new Properties();
            properties.load(new FileInputStream(FILE_PATH.formatted(RESOURCE_PATH, AUTOMATION_PROPERTIES_FILE)));
        } catch (IOException ioException) {
            System.err.println("Exception occurred while loading the properties." +
                    "\n Exception: " + ioException.getLocalizedMessage());
        }
    }

    /**
     * Method to load the locators data into locator repository
     */
    public void loadLocators(){
        try{
            ObjectMapper mapper = new ObjectMapper();
            locatorRepository = mapper.readValue(
                    new File(FILE_PATH.formatted(RESOURCE_PATH, LOCATOR_REPOSITORY_JSON)),
                    LocatorRepository.class);
        }catch (IOException ioException) {
            System.err.println("Exception occurred while loading the properties." +
                    "\n Exception: " + ioException.getLocalizedMessage());
        }
    }

}
