package day12_synchronization;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBaseBeforeAfter;

public class C01_Actions extends TestBaseBeforeAfter {
    @Test
    public void test1() throws InterruptedException {
        // autimationexercises.com adresine gidelim
        driver.get("https://www.automationexercise.com/");
        // product bolumune gidelim
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("a[href=\"/products\"]")).click();
        // ilk urune tiklayalim
        actions.sendKeys(Keys.PAGE_DOWN).perform();// (Keys.PAGE_DOWN) bir tab kadar asagiya iniyoruz
        driver.findElement(By.cssSelector("a[data-product-id=\"1\"]")).click();
    }
}
