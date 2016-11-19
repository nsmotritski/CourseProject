package onliner.forms;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Checkbox;
import webdriver.elements.Dropdown;
import webdriver.elements.Link;
import webdriver.elements.TextBox;

public class RealtyOnlinerPage extends BaseForm {
    //private Link menuItemLink = new Link(By.xpath("//div[@class='catalog-bar']/ul/li/a[.='Телевизоры']"),"MenuItemLink");
    private Dropdown searchPriceMin = new Dropdown(By.xpath(".//*[@id='search-filter-price-from']")," Search Price Min");
    private Dropdown searchPriceMax = new Dropdown(By.xpath(".//*[@id='search-filter-price-to']")," Search Price Max");
    private Checkbox numberOfRooms = new Checkbox(By.xpath(".//div[@id='search-filter']//input[contains(@data-bind,'2')]"),"Number Of Rooms");
    private TextBox areaMin = new TextBox(By.xpath(".//*[@id='search-filter-area-from']"),"Area Min");
    private TextBox areaMax = new TextBox(By.xpath(".//*[@id='search-filter-area-to']"),"Area Max");
    private TextBox yearFrom = new TextBox(By.xpath(".//*[@id='search-filter-year-from']"));


    public RealtyOnlinerPage() {
        super(By.xpath("//div[@id='fast-search']/form/input[@data-project='catalog_public']"), "Catalog Onliner.by");
    }

    public void setMinPrice (String minPrice) {searchPriceMin.setValue(minPrice);}

    public void setMaxPrice (String maxPrice) {searchPriceMax.setValue(maxPrice);}

    public void setNumberOfRooms () {
        numberOfRooms.click();
    }

    public void setAreaMin(Integer i) {
        areaMin.setText(i.toString());
    }

    public void setAreaMax(Integer i) {
        areaMax.setText(i.toString());
    }

    public void setYearFrom(Integer i) {
        yearFrom.setText(i.toString());
    }


    public void applyFilters (String minPrice,String maxPrice, int areaMin, int areaMax, int yearFrom) {
        setMinPrice(minPrice);
        setMaxPrice(maxPrice);
        setNumberOfRooms();
        //browser.pageScrollDown();
        setAreaMin(areaMin);
        setAreaMax(areaMax);
        setYearFrom(yearFrom);
    }
}
