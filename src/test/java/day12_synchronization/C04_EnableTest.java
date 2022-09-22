package day12_synchronization;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;

import java.time.Duration;

public class C04_EnableTest extends TestBaseBeforeAfter {
    @Test
    public void isEnable() throws InterruptedException {
        // Bir class olusturun : EnableTest
        //Bir metod olusturun : isEnabled()
        //https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textBox= driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(textBox.isEnabled());
        //Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("//*[text()='Enable']")).click();
        //“It’s enabled!” mesajinin goruntulendigini dogrulayın.   //*[text()="It's enabled!"]
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(textBox)); // textBox etkin olana kadar bekletiyoruz
        //Textbox’in etkin oldugunu(enabled) dogrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=\"It's enabled!\"]")).isDisplayed());
        Assert.assertTrue(textBox.isEnabled());
        Thread.sleep(3000);
    }
}
