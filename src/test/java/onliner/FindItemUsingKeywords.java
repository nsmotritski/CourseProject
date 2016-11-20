package onliner;

import onliner.forms.BaraholkaOnlinerPage;
import onliner.forms.OnlinerHomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import webdriver.BaseTest;

public class FindItemUsingKeywords extends BaseTest {
    String keyword1;
    String keyword2;

    @BeforeTest
    @Parameters({"keyword1","keyword2"})
    public void beforeTest(String itemKeyword1,String itemKeyword2) {
        keyword1 = itemKeyword1;
        keyword2 = itemKeyword2;
    }

    @Test
    public void runTest() {

        logger.step(1);
        OnlinerHomePage onlinerHomePage = new OnlinerHomePage();
        browser.windowMaximise();

        logger.step(2);
        onlinerHomePage.clickBaraholka();

        logger.step(3);
        BaraholkaOnlinerPage baraholkaOnlinerPage = new BaraholkaOnlinerPage();
        baraholkaOnlinerPage.searchKeywords(keyword1,keyword2);
        baraholkaOnlinerPage.launchItemsSearch();
        logger.info("Items search is launched");

        logger.step(4);
        baraholkaOnlinerPage.waitSearchResultsLoaded();
        Assert.assertTrue(baraholkaOnlinerPage.itemByKeywordsIsFound(keyword1,keyword2));
    }
}
