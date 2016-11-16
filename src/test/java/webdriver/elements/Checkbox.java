package webdriver.elements;

import org.openqa.selenium.By;

public class Checkbox extends BaseElement {
    public Checkbox(final By locator, final String name) {
        super(locator, name);
    }

    public Checkbox (String string, String name) {
        super(string, name);
    }

    public Checkbox (By locator) {
        super(locator);
    }

    protected String getElementType() {
        return getLoc("loc.label");
    }

    public boolean isEnabled(){
        return this.getElement().isEnabled();
    }
}
