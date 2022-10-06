package day16;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C02_JSExecutor extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        // amazon sayfasina gidelim
        driver.get("https://www.amazon.com");
        // asagidaki carrers butonunu gorunceye kadar js ile scroll yapalim
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement careers = driver.findElement(By.xpath("//*[text()='Careers']"));
        jse.executeScript("arguments[0].scrollIntoView(true);", careers);
        // Carrers butonuna js ile click yapalim
        jse.executeScript("arguments[0].click()",careers);
    }
}
