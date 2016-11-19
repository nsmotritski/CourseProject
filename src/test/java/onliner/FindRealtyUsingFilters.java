package onliner;

import onliner.forms.CatalogOnlinerPage;
import onliner.forms.CatalogOnlinerTVs;
import onliner.forms.OnlinerHomePage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import webdriver.BaseTest;

import java.util.List;

public class FindRealtyUsingFilters extends BaseTest {
    int maxPrice;
    String manufacturer;
    int minReleaseYear;
    int diagonalMin;
    int diagonalMax;
    List<String> searchResults;

    @BeforeTest
    @Parameters({"maxPrice", "manufacturer", "minimumReleaseYear", "diagonalMin", "diagonalMax"})
    public void beforeTest(int maximumPrice, String manufacturerValue, int minimumReleaseYear, int diagonalMinimum, int diagonalMaximum) {
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
    }
}
