package onliner.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import webdriver.BaseForm;
import webdriver.elements.Checkbox;
import webdriver.elements.Dropdown;
import webdriver.elements.Link;
import webdriver.elements.TextBox;

public class RealtyOnlinerPage extends BaseForm {
    //private Link menuItemLink = new Link(By.xpath("//div[@class='catalog-bar']/ul/li/a[.='Телевизоры']"),"MenuItemLink");
    private TextBox searchPriceMin = new TextBox(By.xpath(".//*[@id='search-filter-price-from']"),"Search Price Min");
    private TextBox searchPriceMax = new TextBox(By.xpath(".//*[@id='search-filter-price-to']"),"Search Price Max");
    private Checkbox numberOfRooms = new Checkbox(By.xpath(".//div[@id='search-filter']//input[contains(@data-bind,'2')]"),"Number Of Rooms");
    private TextBox areaMin = new TextBox(By.xpath(".//*[@id='search-filter-area-from']"),"Area Min");
    private TextBox areaMax = new TextBox(By.xpath(".//*[@id='search-filter-area-to']"),"Area Max");
    private TextBox yearFrom = new TextBox(By.xpath(".//*[@id='search-filter-year-from']"));
    private Link searchResult = new Link(By.xpath("//a[contains(@class,'classified')]"),"Search Result");

    public void waitSearchResultsLoaded() {
        searchResult.waitForIsElementPresent();
    }

    public boolean isSearchResultFound() {
        return searchResult.isPresent();
    }


    public RealtyOnlinerPage() {
        super(By.xpath(".//span[contains(.,'Продажа')]"), "Realty Onliner.by");
    }

    public void setMinPrice (Integer i) {searchPriceMin.setText(i.toString());}

    public void setMaxPrice (Integer i) {searchPriceMax.setText(i.toString());}

    public void setNumberOfRooms () {numberOfRooms.sendKeys(Keys.SPACE);
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


    public void applyFilters (int minPrice,int maxPrice, int areaMin, int areaMax, int yearFrom) {
        setMinPrice(minPrice);
        setMaxPrice(maxPrice);
        //setNumberOfRooms();
        //browser.pageScrollDown();
        setAreaMin(areaMin);
        setAreaMax(areaMax);
        setYearFrom(yearFrom);
    }
}
