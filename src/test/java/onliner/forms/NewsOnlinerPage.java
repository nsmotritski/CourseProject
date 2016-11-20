package onliner.forms;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.*;

import java.util.List;

public class NewsOnlinerPage extends BaseForm {
    private Link moreNews = new Link(By.xpath(".//span[contains(@class,'news-more')]/parent::a"),"Load more news");
    private Container news = new Container(By.xpath(".//div[contains(@class,'news-tidings')]//a[contains(@class,'link')]"));
    private List<String> newsHeaders;
    private List<String> newsContents;

    public NewsOnlinerPage() { super(By.xpath(".//span[contains(@class,project-navigation) and .='Технологии']"), "Technologies Onliner.by"); }

    public void waitSearchResultsLoaded() {
        news.waitForIsElementPresent();
    }

    public List<String> getNewsHeaders () {
        List<String> result;
        result = news.getElementsTexts(By.xpath(".//div[contains(@class,'news-tidings')]//a[contains(@class,'link')]/span[1]"));
        for (String s:result) {
            logger.info("News header found: " +s);
        }
        return result;
    }

    public List<String> getNewsContents () {
        List<String> result;
        result = news.getElementsTexts(By.xpath(".//div[contains(@class,'news-tidings')]//div[contains(@class,'speech')]"));
        for (String s:result) {
            logger.info("News contents found: " +s);
        }
        return result;
    }

    private boolean checkTextContains (String text,String keyword1,String keyword2) {
        return (text.toLowerCase().contains(keyword1.toLowerCase()) && text.toLowerCase().contains(keyword2.toLowerCase()));
    }

    public void loadMoreNews () {
        moreNews.click();
    }

    public boolean newsWithKeywordIsPresent (String keyword1, String keyword2) {
        boolean result = false;
        newsHeaders = getNewsHeaders();
        newsContents = getNewsContents();
        for (String newsHeader:newsHeaders) {
            if (checkTextContains(newsHeader,keyword1,keyword2)) {
                result = true;
            }
        }
        for (String newsContent:newsContents) {
            if (checkTextContains(newsContent,keyword1,keyword2)) {
                result = true;
            }
        }
        return result;
    }
}
