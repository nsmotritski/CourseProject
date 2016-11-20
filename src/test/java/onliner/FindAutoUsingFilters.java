package onliner;

import onliner.forms.AutoOnlinerPage;
import onliner.forms.OnlinerHomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import webdriver.BaseTest;

public class FindAutoUsingFilters extends BaseTest {
    int minPrice;
    int maxPrice;
    String manufacturer;
    String bodyType;
    int yearFrom;
    String engineType;

    @BeforeTest
    @Parameters({"minPrice","maxPrice","manufacturer","bodyType","yearFrom","engineType"})
    public void beforeTest(int minimumPrice,int maximumPrice,String autoManufacturer,String autoBodyType,int minimumReleaseYear,String autoEngine) {
        minPrice = minimumPrice;
        maxPrice = maximumPrice;
        manufacturer = autoManufacturer;
        bodyType = autoBodyType;
        yearFrom = minimumReleaseYear;
        engineType = autoEngine;
    }

    @Test
    public void runTest() {

        logger.step(1);
        OnlinerHomePage onlinerHomePage = new OnlinerHomePage();
        browser.windowMaximise();

        logger.step(2);
        onlinerHomePage.clickAuto();

        logger.step(3);
        AutoOnlinerPage autoOnlinerPage = new AutoOnlinerPage();
        autoOnlinerPage.applyFilters(minPrice,maxPrice,manufacturer,bodyType,yearFrom,engineType);
        logger.info("All Filters applied correctly");

        logger.step(4);
        autoOnlinerPage.waitSearchResultsLoaded();
        Assert.assertTrue(autoOnlinerPage.isSearchResultFound());
    }
}
