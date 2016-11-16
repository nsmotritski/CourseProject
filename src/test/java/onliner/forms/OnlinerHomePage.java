package onliner.forms;

import org.openqa.selenium.By;
import org.testng.Assert;
import webdriver.BaseForm;
import webdriver.elements.Label;
import webdriver.elements.Link;

    public class OnlinerHomePage extends BaseForm {
        private Link topMenuItem = new Link(By.xpath("//span[.='Каталог']/parent::a"),"TopMenuCatalog");
        private Label lbLogo = new Label(By.xpath(".//img[@alt='Onliner']"),"onliner logo");


        public OnlinerHomePage() {
            super(By.xpath("//div[@id='fast-search']/form/input[@data-project='onliner_main']"), "Onliner.by");
        }

        public void assertLogo(){assert(lbLogo.isPresent());}

        public void clickMenuItem () {
            topMenuItem.click();
        }

    }
