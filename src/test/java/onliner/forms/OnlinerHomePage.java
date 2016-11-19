package onliner.forms;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Link;

    public class OnlinerHomePage extends BaseForm {
        private Link catalogMenuItem = new Link(By.xpath("//span[.='Каталог']/parent::a"),"TopMenuCatalog");
        private Link realtyMenuItem = new Link(By.xpath("//span[.='Каталог']/parent::a"),"TopMenuCatalog");


        public OnlinerHomePage() {
            super(By.xpath("//div[@id='fast-search']/form/input[@data-project='onliner_main']"), "Onliner.by");
        }

        public void clickCatalog() {
            catalogMenuItem.click();
        }

        public void clickRealty() {
            realtyMenuItem.click();
        }

    }
