package webdriver.elements;

import org.openqa.selenium.By;

/**
 * Created by Николай on 16.11.2016.
 */
public class Container extends BaseElement {

    public Container(final By locator, final String name) {
        super(locator, name);
    }

    public Container(String string, String name) {
        super(string, name);
    }

    public Container(By locator) {
        super(locator);
    }

    protected String getElementType() {
        return getLoc("loc.label");
    }


}
