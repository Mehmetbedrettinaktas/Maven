package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03_DropDown {
    /*
         ●Bir class oluşturun:C3_DropDownAmazon
        ●https://www.amazon.com/ adresine gidin.
        -Test1
        Arama kutusunun yanindaki kategori menusundeki kategori sayisinin45
        oldugunu testedin
        -Test2
        1.Kategori menusunden Books seceneginisecin
        2.Arama kutusuna Java yazin vearatin
        3.Bulunan sonuc sayisiniyazdirin
        4.Sonucun Java kelimesini icerdigini testedin
     */
    WebDriver driver;
    Select select;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
    }
    @After
    public void tearDown(){
         driver.close();
    }
    // Test1
    @Test
    public void test1(){
        // Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
        // oldugunu testedin
        WebElement ddm= driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        select=new Select(ddm);
        List<WebElement> ddmList=select.getOptions();
        System.out.println(ddmList.size());
        int expectedSayi=45;
        int actualDdsayisi=ddmList.size();
        Assert.assertNotEquals(expectedSayi,actualDdsayisi);
        /*
        Dropdown menuye ulasmak icin Select classindan bir obje olustururuz
        ve locate etttigimiz dropdown webelementini Select classina tanimlariz
        ve getOption methodunu kullanarak dropdown'u bir list'e atarak
        dropdawn menunun butun elemanlarinin sayisina ulasabiliriz.
         */

    }
    //-Test2
    @Test
    public void test2(){
        // 1.Kategori menusunden Books secenegini secin
        WebElement ddm= driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        select =new Select(ddm);
      //  select.selectByVisibleText("Books"); // Eger Dropdown  menudeki option'a string olarak ulasmak istersek bu methodu kullaniriz

      //  select.selectByIndex(5);// Eger dropdown menusunun index'ine ulasmak istersek bu methodu kullaniriz.
        select.selectByValue("search-alias=stripbooks-intl-ship"); // Valu ile

       // Dropdown menude sectigimiz optiona ulasmak istersek
        // select.getFirstSelectedOption() methodunu kullaniriz.

        System.out.println(select.getFirstSelectedOption().getText());
        // Eger Dropdown menusundeki optiona value ile ulasmak istersek bu methodu kullaniriz

        // 2.Arama kutusuna Java yazin vearatin
     driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
        // 3.Bulunan sonuc sayisiniyazdirin
        WebElement sonucYazisi= driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucYazisi.getText());
        // 4.Sonucun Java kelimesini icerdigini testedin
        String expectedSonuc="Java";
        String actualSonuc = sonucYazisi.getText();
        Assert.assertTrue(actualSonuc.contains(expectedSonuc));


    }
}
