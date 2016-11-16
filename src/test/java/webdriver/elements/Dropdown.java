package webdriver.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

/**
     * Created by Николай on 05.11.2016.
     */
public class Dropdown extends BaseElement {
    /**
     * Constructor
     * @param locator locator
     * @param name name
     */
    public Dropdown(final By locator, final String name) {
        super(locator, name);
    }

    /**
     * Constructor
     * @param string locator
     * @param name name
     */
    public Dropdown(final String string, final String name) {
        super(string, name);
    }

    /**
     * Returns Element type
     * @return Element type
     */
    protected String getElementType() {
        return getLoc("loc.text.field");
    }

    /**
     * Constructor
     * @param locator locator
     */
    public Dropdown(final By locator) {
        super(locator);
    }

    /**
     * Enter the text in the box
     * @param value text
     */
    public void type(final String value) {
        waitForIsElementPresent();
        info(String.format(getLoc("loc.text.typing") + " '%1$s'", value));
        if (browser.getDriver() instanceof JavascriptExecutor) {
            ((JavascriptExecutor)browser.getDriver()).executeScript("arguments[0].style.border='3px solid red'", element);
        }
        element.sendKeys(value);
    }

    /**
     * Clear field and type text
     * @param value text
     */
    public void setText(final String value) {
        waitForIsElementPresent();
        element.clear();
        type(value);
    }

    public void setValue(final String value) {
        Select dropdown = new Select(this.getElement());
        dropdown.selectByValue(value);
    }


    /**
     * Gets value of field
     * @return value
     */
    public String getValue() {
        waitForIsElementPresent();
        return element.getAttribute("value");
    }
}
