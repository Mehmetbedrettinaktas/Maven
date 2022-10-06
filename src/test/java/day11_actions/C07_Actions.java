package day11_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C07_Actions extends TestBaseBeforeAfter {

    //1Yeni bir class olusturalim: MouseActions1
    //2https://the-internet.herokuapp.com/context_menu sitesine gidelim
    //3- Cizili alan uzerinde sag click yapalim
    //4 Alert’te cikan yazinin “You selected a context menu” oldugunu
    //test edelim.
    //5 Tamam diyerek alert’i kapatalim
    //6 Elemental Selenium linkine tiklayalim
    //7 Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
    @Test
    public void test1(){
        //2-https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //3- Cizili alan uzerinde sag click yapalim
        Actions actions = new Actions(driver);
      WebElement sag=  driver.findElement(By.xpath("//div[@id='hot-spot']"));
      actions.contextClick(sag).perform();

        //4 Alert’te cikan yazinin “You selected a context menu” oldugunu
      String actualtitle=  driver.switchTo().alert().getText();
      String expectedMesaj="You selected a context menu";
      Assert.assertEquals(expectedMesaj,actualtitle);

        //test edelim.
        //5 Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        //6 Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();
        //7 Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        String actualYazielementi=driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).getText();
        String expectedYaziElementi="Elemental Selenium";
        Assert.assertEquals(expectedYaziElementi,actualYazielementi);





    }
}
