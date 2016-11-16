package onliner.forms;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Label;
import webdriver.elements.Link;

public class TVDetailPage extends BaseForm {
    private Label tvReleaseYear = new Label(By.xpath(".//td[contains(.,'Дата')] /following-sibling::td/span"),"tvReleaseYear");
    private Label tvDiagonal = new Label(By.xpath(".//td[contains(.,'Диагональ')] /following-sibling::td/span"),"tvDiagonal");
    private Link tvPrice = new Link(By.xpath(".//a[contains(@class,'info-price-value_primary')]"));
    private Label tvManufacturer = new Label(By.xpath(".//h2[contains(@class,'catalog-masthead')]"));

    public TVDetailPage() {
        super(By.xpath("//div[@id='fast-search']/form/input[@data-project='catalog_public']"), "TV Detail Catalog.Onliner.by");
    }

    
}
