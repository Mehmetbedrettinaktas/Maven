package day11_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.nio.file.WatchEvent;

public class C02_Odev extends TestBaseBeforeAfter {
    @Test
    public void test1(){
        // Bir Class olusturalim KeyboardActions2
        //https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
        // 3- video’yu gorecek kadar asagi inin
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //videoyu izlemek icin Play tusuna basin
        WebElement iframeYazisi= driver.findElement(By.xpath("//*[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(iframeYazisi);
        WebElement youtube = driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        youtube.click();
        //videoyu calistirdiginizi test edin
        WebElement youtubeLinki=driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(youtubeLinki.isDisplayed());
        driver.switchTo().defaultContent( );

    }
}
