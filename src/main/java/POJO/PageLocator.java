package POJO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PageLocator {
    private String page;
    private Locator[] locators;
}
