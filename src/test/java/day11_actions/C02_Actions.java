package day11_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C02_Actions extends TestBaseBeforeAfter {
    @Test
    public void test1() {

       // 1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//button[@class='_42ft _4jy0 _9xo7 _4jy3 _4jy1 selected _51sy']")).click();
       // 2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//*[text()='Yeni Hesap Oluştur']")).click();
       // 3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim



        WebElement isimKutusu = driver.findElement(By.xpath("//input[@name='firstname']"));

        actions.click(isimKutusu)
                .sendKeys("Selo")
                .sendKeys(Keys.TAB)
                .sendKeys("gonul")
                .sendKeys(Keys.TAB)
                .sendKeys("gfr@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("gfr@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("12345sg.")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("10")
                .sendKeys(Keys.TAB)
                .sendKeys("Mayis")
                .sendKeys(Keys.TAB)
                .sendKeys("2000")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_DOWN) // .sendKeys(Keys.RIGHT), .sendKeys(Keys.LEFT)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();


    }
}
