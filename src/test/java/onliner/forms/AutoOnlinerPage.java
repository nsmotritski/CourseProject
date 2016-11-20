package onliner.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import webdriver.BaseForm;
import webdriver.elements.Checkbox;
import webdriver.elements.Dropdown;
import webdriver.elements.Link;
import webdriver.elements.TextBox;

public class AutoOnlinerPage extends BaseForm {
    private Dropdown searchPriceMin = new Dropdown(By.xpath("//select[@name='min-price']"),"Search Price Min");
    private Dropdown searchPriceMax = new Dropdown(By.xpath("//select[@name='max-price']"),"Search Price Max");
    private Dropdown manufacturer = new Dropdown(By.xpath(".//select[contains(@name,'models_manufactures')]"),"Manufacturer");
    //private Dropdown model = new Dropdown(By.xpath("//select[contains(@name,'models_id')]"),"Model");
    private Checkbox bodyType = new Checkbox(By.xpath("//text()[contains(.,'Седан')] /preceding-sibling::input"),"Body Type");
    private Dropdown yearFrom = new Dropdown(By.xpath(".//select[@name='min-year']"));
    private Checkbox engineType = new Checkbox(By.xpath("//text()[contains(.,'Дизель')] /preceding-sibling::input"),"Engine Type");

    private Link searchResult = new Link(By.xpath(".//tr[contains(@id,'car')]"),"Search Result");

    public AutoOnlinerPage() { super(By.xpath(".//h1"), "Auto Onliner.by"); }

    public void waitSearchResultsLoaded() {
        searchResult.waitForIsElementPresent();
    }

    public boolean isSearchResultFound() {return searchResult.isPresent();}

    public void setMinPrice (Integer i) {searchPriceMin.setValue(i.toString()); }

    public void setMaxPrice (Integer i) {searchPriceMax.setValue(i.toString()); }

    public void setManufacturer(String s) {
        if (manufacturer.getText().contains(s)) {
            manufacturer.setText(s);
        }
    }

    public void setBodyType() {
        bodyType.click();
    }

    public void setYearFrom(Integer i) {
        if (yearFrom.getText().contains(i.toString())) {
            yearFrom.setText(i.toString());
        }
    }

    public void setEngineType() {engineType.click();}


    public void applyFilters (int minPrice,int maxPrice, String manufacturer,String bodyType,int yearFrom,String engineType) {
        setMinPrice(minPrice);
        setMaxPrice(maxPrice);
        setManufacturer(manufacturer);
        setBodyType();
        setYearFrom(yearFrom);
        setEngineType();
    }
}
