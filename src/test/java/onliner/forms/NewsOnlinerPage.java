package onliner.forms;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.*;

import java.util.List;

public class NewsOnlinerPage extends BaseForm {
    private Link moreNews = new Link(By.xpath(".//span[contains(@class,'news-more')]/parent::a"),"Load more news");
    private Container news = new Container(By.xpath(".//div[contains(@class,'news-tidings')]//a[contains(@class,'link')]"));
    private List<String> newsHeaders;// = news.getElements("//span");

    public NewsOnlinerPage() { super(By.xpath(".//span[contains(@class,project-navigation) and .='Технологии']"), "Technologies Onliner.by"); }

    public List<String> getNewsHeaders () {
        return news.getElements(By.xpath(".//span"));
    }

    public void loadMoreNews () {
        moreNews.click();
    }

    public boolean newsWithKeywordIsPresent (String keyword1, String keyword2) {
        boolean result = false;
        newsHeaders = getNewsHeaders();
        for (String newsHeader:newsHeaders) {
            if ((newsHeader.toLowerCase().contains(keyword1.toLowerCase()))&&(newsHeader.toLowerCase().contains(keyword2.toLowerCase()))) {
                result = true;
            }
        }
        return result;
    }
}
