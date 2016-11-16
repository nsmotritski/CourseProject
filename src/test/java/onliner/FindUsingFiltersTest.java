package onliner;

import onliner.forms.CatalogOnlinerPage;
import onliner.forms.CatalogOnlinerTVs;
import onliner.forms.OnlinerHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import webdriver.BaseTest;
import webdriver.elements.Link;

import java.util.ArrayList;
import java.util.List;

public class FindUsingFiltersTest extends BaseTest {
    int maxPrice;
    String manufacturer;
    int minReleaseYear;
    int diagonalMin;
    int diagonalMax;



    @BeforeTest
    @Parameters ({"maxPrice","manufacturer","minimumReleaseYear","diagonalMin","diagonalMax"})
    public void beforeTest (int maximumPrice,String manufacturerValue,int minimumReleaseYear,int diagonalMinimum,int diagonalMaximum) {
        maxPrice = maximumPrice;
        manufacturer = manufacturerValue;
        minReleaseYear = minimumReleaseYear;
        diagonalMin = diagonalMinimum;
        diagonalMax = diagonalMaximum;
    }

    @Test
    public void runTest() {


        logger.step(1);
        OnlinerHomePage onlinerHomePage = new OnlinerHomePage();
        browser.windowMaximise();

        logger.step(2);
        onlinerHomePage.clickMenuItem();

        logger.step(3);
        CatalogOnlinerPage catalogOnlinerPage = new CatalogOnlinerPage();
        catalogOnlinerPage.navigateMenuItem();

        logger.step(4);
        CatalogOnlinerTVs catalogOnlinerTVs = new CatalogOnlinerTVs();
        catalogOnlinerTVs.applyFilters(maxPrice, minReleaseYear, diagonalMin + "0", diagonalMax + "0");
        logger.info("All Filters applied correctly");


        logger.step(4);
        browser.waitForListOfElements(catalogOnlinerTVs.searchResultsDiv,".//div[@id='schema-products']//div[contains(@class,'title')]");
        List<WebElement> searchItemList = catalogOnlinerTVs.searchResultsDiv.getElements(By.xpath(".//div[@id='schema-products']//div[contains(@class,'title')]"));
        //searchItemList = browser.getDriver().findElements(By.xpath(".//div[@id='schema-products']//div[contains(@class,'title')]"));
        for (WebElement webElement: searchItemList) {
            logger.info(webElement.getText());
        }
        logger.info("Final line before assert");
        catalogOnlinerTVs.checkResults(searchItemList,"Samsung","1000","","39","42");
    }
}
