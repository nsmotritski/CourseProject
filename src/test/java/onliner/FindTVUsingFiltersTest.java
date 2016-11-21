package onliner;

import onliner.forms.CatalogOnlinerPage;
import onliner.forms.CatalogOnlinerTVs;
import onliner.forms.OnlinerHomePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import webdriver.BaseTest;

import java.util.List;

import static onliner.forms.CatalogOnlinerTVs.checkResults;

public class FindTVUsingFiltersTest extends BaseTest {
    int maxPrice;
    String manufacturer;
    int minReleaseYear;
    int diagonalMin;
    int diagonalMax;
    List<String> searchResults;

  /*  public void checkResults (String manufacturerFilterValue, int maxPriceFilterValue, int releasedAfterYearFilterValue, int diagonalFromFilterValue, int diagonalToFilterValue) {
        for (String url :searchResults) {
            logger.info("Checking TV URL:" + url);
            browser.navigate(url);
            TVDetailPage tvDetailPage = new TVDetailPage();
            tvDetailPage.checkTVParameters(manufacturerFilterValue,maxPriceFilterValue,releasedAfterYearFilterValue, diagonalFromFilterValue, diagonalToFilterValue);
        }
    }*/



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
        onlinerHomePage.clickCatalog();

        logger.step(3);
        CatalogOnlinerPage catalogOnlinerPage = new CatalogOnlinerPage();
        catalogOnlinerPage.navigateMenuItem();

        logger.step(4);
        CatalogOnlinerTVs catalogOnlinerTVs = new CatalogOnlinerTVs();
        catalogOnlinerTVs.applyFilters(maxPrice, minReleaseYear, diagonalMin + "0", diagonalMax + "0");
        logger.info("All Filters applied correctly");


        logger.step(5);
        browser.waitForListOfElements(catalogOnlinerTVs.searchResultsDiv,".//div[@id='schema-products']//div[contains(@class,'title')]");
        searchResults = catalogOnlinerTVs.getSearchRetults();
        for (String s:searchResults) {
            logger.info(s);
        }
        checkResults(searchResults,manufacturer,maxPrice,minReleaseYear,diagonalMin,diagonalMax);
/*        List<WebElement> searchItemList = catalogOnlinerTVs.searchResultsDiv.getElements(By.xpath(".//div[@id='schema-products']//div[contains(@class,'title')]"));
        //searchItemList = browser.getDriver().findElements(By.xpath(".//div[@id='schema-products']//div[contains(@class,'title')]"));
        for (WebElement webElement: searchItemList) {
            logger.info(webElement.getText());
        }
        logger.info("Final line before assert");
        catalogOnlinerTVs.checkResults(searchItemList,"Samsung","1000","","39","42");*/
    }

    @AfterTest
    public void afterTest () {
        browser.checkAndKill();
    }
}
