package onliner.forms;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Link;

    public class OnlinerHomePage extends BaseForm {
        private Link catalogMenuItem = new Link(By.xpath("//span[.='Каталог']/parent::a"),"TopMenuCatalog");
        private Link realtyMenuItem = new Link(By.xpath("//span[.='Дома и квартиры']/parent::a"),"TopMenuRealty");
        private Link autoMenuItem = new Link(By.xpath("//span[.='Автобарахолка']/parent::a"),"TopMenuAuto");
        private Link newsMenuItem = new Link(By.xpath(".//h2/a[.='Технологии']"),"News Technologies");


        public OnlinerHomePage() {
            super(By.xpath("//div[@id='fast-search']/form/input[@data-project='onliner_main']"), "Onliner.by");
        }

        public void clickCatalog() {
            catalogMenuItem.click();
        }

        public void clickRealty() {realtyMenuItem.click(); }

        public void clickAuto() { autoMenuItem.click(); }

        public void clickTechNews() { newsMenuItem.click(); }

    }
