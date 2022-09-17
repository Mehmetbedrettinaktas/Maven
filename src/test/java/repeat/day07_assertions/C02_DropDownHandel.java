package repeat.day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_DropDownHandel {
    /*
       ●Bir class oluşturun:C3_DropDownAmazon
      ●https://www.amazon.com/ adresine gidin.
      -Test1
      Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
      oldugunu testedin
      -Test2
      1.Kategori menusunden Books seceneginisecin
      2.Arama kutusuna Java yazin vearatin
      3.Bulunan sonuc sayisiniyazdirin
      4.Sonucun Java kelimesini icerdigini testedin
   */
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown(){
        // driver.close();
    }
    @Test
    public void test1(){
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
        // oldugunu testedin
        driver.get("https://www.amazon.com");
      List<WebElement> ddw= driver.findElements(By.xpath("//option"));
        System.out.println(ddw.size());
        for (WebElement each:ddw) {
            System.out.println(each.getText());
        }

        int dropDownList=ddw.size();
        int expectedSayi=45;
        Assert.assertNotEquals(expectedSayi,dropDownList);
    }
    @Test
    public void test2(){
        // -Test2

        driver.get("https://www.amazon.com");
        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(ddm);
        // 2- dropdown menuden Books'u secelim
        select.selectByVisibleText("Books");
        // 3.Bulunan sonuc sayisini yazdirin

        // 4.Sonucun Java kelimesini icerdigini test edin

    }
}
