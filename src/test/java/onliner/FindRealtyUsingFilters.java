package onliner;

import onliner.forms.CatalogOnlinerPage;
import onliner.forms.CatalogOnlinerTVs;
import onliner.forms.OnlinerHomePage;
import onliner.forms.RealtyOnlinerPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import webdriver.BaseTest;

import java.util.List;

public class FindRealtyUsingFilters extends BaseTest {
    int minPrice;
    int maxPrice;
    int areaMin;
    int areaMax;
    int yearFrom;
    List<String> searchResults;

    @BeforeTest
    @Parameters({"minPrice", "maxPrice", "areaMin", "areaMax", "yearFrom"})
    public void beforeTest(int minimumPrice,int maximumPrice, int minimumArea,int maximumArea, int minimumReleaseYear) {
        minPrice = minimumPrice;
        maxPrice = maximumPrice;
        areaMin = minimumArea;
        areaMax = maximumArea;
        yearFrom = minimumReleaseYear;
    }

    @Test
    public void runTest() {

        logger.step(1);
        OnlinerHomePage onlinerHomePage = new OnlinerHomePage();
        browser.windowMaximise();

        logger.step(2);
        onlinerHomePage.clickRealty();

        logger.step(3);
        RealtyOnlinerPage realtyOnlinerPage = new RealtyOnlinerPage();
        realtyOnlinerPage.applyFilters(minPrice,maxPrice,areaMin,areaMax,yearFrom);
        logger.info("All Filters applied correctly");

        logger.step(4);
        realtyOnlinerPage.waitSearchResultsLoaded();
        Assert.assertTrue(realtyOnlinerPage.isSearchResultFound());
    }
}
