package onliner.forms;

import org.openqa.selenium.By;
import org.testng.Assert;
import webdriver.BaseForm;
import webdriver.elements.Label;
import webdriver.elements.Link;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TVDetailPage extends BaseForm {
    private Label tvReleaseYear = new Label(By.xpath(".//td[contains(.,'Дата')] /following-sibling::td/span"),"tvReleaseYear");
    private Label tvDiagonal = new Label(By.xpath(".//td[contains(.,'Диагональ')] /following-sibling::td/span"),"tvDiagonal");
    private Link tvPrice = new Link(By.xpath(".//a[contains(@class,'info-price-value_primary')]"));
    private Label tvManufacturer = new Label(By.xpath(".//h2[contains(@class,'catalog-masthead')]"));

    public TVDetailPage() {
        super(By.xpath("//div[@id='fast-search']/form/input[@data-project='catalog_public']"), "TV Detail Catalog.Onliner.by");
    }

    private int getMinPrice(Link link) {
        String minPrice = link.compileElementTextAgainstPattern("[0-9]*,[0-9][0-9]");
        return Integer.parseInt(minPrice);
    }

/*    private int getMaxPrice(Link link) {
        String maxPrice = link.compileElementTextAgainstPattern("\\S\\s[0-9]*,[0-9][0-9]");
        return Integer.parseInt(maxPrice.substring(2));
    }*/

    private int getDiagonalValue (Label label) {
        String s = label.compileElementTextAgainstPattern("[0-9][0-9]\"");
        return Integer.parseInt(s);
    }

    private int getReleaseYear (Label label) {
        String releaseYear = label.compileElementTextAgainstPattern("[0-9][0-9][0-9][0-9]");
        return Integer.parseInt(releaseYear);
    }

    public boolean checkTVManufacturer (String manufacturer) {
        logger.info("Checking that TV manufacturer is " + manufacturer);
        return tvManufacturer.getText().contains(manufacturer);
    }

    public boolean checkTVDiagonal (int tvDiagonalMin, int tvDiagonalMax) {
        logger.info("Checking that TV diagonal is between " + tvDiagonalMin + " and " + tvDiagonalMax);
        return (getDiagonalValue(tvDiagonal) >= tvDiagonalMin) && (getDiagonalValue(tvDiagonal) <= tvDiagonalMax);
    }

    public boolean checkTVPrice (int price) {
        logger.info("Checking that TV price is less than " + price);
        return price >= getMinPrice(tvPrice);
    }

    public boolean checkTVReleaseYear (int releaseYear) {
        logger.info("Checking that TV release year is not earlier than " + releaseYear);
        return releaseYear <= getReleaseYear(tvReleaseYear);
    }

    public void checkTVParameters (String manufacturer,int maxPrice, int minReleaseYear, int minDiagonal, int maxDiagonal) {
        Assert.assertTrue(checkTVManufacturer(manufacturer));
        Assert.assertTrue(checkTVDiagonal(minDiagonal,maxDiagonal));
        Assert.assertTrue(checkTVPrice(maxPrice));
        Assert.assertTrue(checkTVReleaseYear(minReleaseYear));
    }
}
