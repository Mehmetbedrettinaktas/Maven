package day11_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C06_Odev1 extends TestBaseBeforeAfter {
    @Test
    public void test1() throws InterruptedException {
        //Yeni Class olusturun ActionsClassHomeWork
        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        // 2- Hover over Me First" kutusunun ustune gelin
        WebElement hover = driver.findElement(By.xpath("(//*[@class='dropbtn'])[1]"));
        actions.moveToElement(hover).perform();
        Thread.sleep(2000);
        //Link 1" e tiklayin
        driver.findElement(By.xpath("//*[text()='Link 1']")).click();
        //Popup mesajini yazdirin
        System.out.println("Popup mesaji : "+driver.switchTo().alert().getText());
        Thread.sleep(2000);
        //Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //“Click and hold" kutusuna basili tutun
        WebElement clickAnHoldButonu = driver.findElement(By.xpath("//*[text()='Click and Hold!']"));
        actions.clickAndHold(clickAnHoldButonu).perform();
        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        WebElement clickAnHolddaCikanYazi = driver.findElement(By.xpath("//*[text()='Well done! keep holding that click now.....']"));
        System.out.println(clickAnHolddaCikanYazi.getText());
        //8- “Double click me" butonunu cift tiklayin
        WebElement doubleClickMi= driver.findElement(By.xpath("//*[@id='double-click']"));
        actions.doubleClick(doubleClickMi).perform();

    }
}
