package day06_RadioButon;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Assertion {
        // assertTRUE (TRUE)---> PASSED
        // assertFALSE (FALSE)---> PASSED
        // assertTRUE (FALSE)---> FAILED
        // assertFALSE (TRUE)---> FAILED

       // Not : BeforeAfter methodunda testleri farklı sayfalarda açıp kapatıyor,
       // BeforeAfterCLass methodlarında aynı sayfada açıp sonra kapatıyor.
       // BeforeAfter methodunda methodların static yapmaya gerek yok
       // ama BeforeAfterCLass'da static yapmak zorunlu.

    /*
    amazon sayfasina gidelim ve uc farkli test methodu olusturalim,
    1 -Url'nin amazon icerdigini test edelim
    2- Title'in  facebook icermedigini test edelim
    3- sol ust kosede amazon logosunun gorundugunu test edelim.
     */
   static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com"); // ilk amazona
    }
    @AfterClass
    public static void tearDown(){
      //  driver.close();
    }
    @Test
    public void test1(){
       // -Url'nin amazon icerdigini test edelim
        driver.get("https://www.amazon.com"); // ilk amazona
        String expectedUrl="https://www.amazon.com";
        String actualUrl= driver.getCurrentUrl();
       // Assert.assertTrue(actualUrl.contains(expectedUrl));
        //Assert.assertEquals("Url'ler esit degil" +expectedUrl,actualUrl);
        Assert.assertNotEquals(expectedUrl,actualUrl);


    }
    @Test
    public void test2(){
    //2- Title'in  facebook icermedigini test edelim
        String actualTitle= driver.getTitle();
        String expectedTitle="facebook";
        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }
    @Test
    public void test3(){
        //3- sol ust kosede amazon logosunun gorundugunu test edelim.
        WebElement logo= driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logo.isDisplayed());
    }
    @Test
    public void test4(){
        //d- Url'nin www.facebook.com olduğunu test edin
        String expectedUrl = "www.facebook.com";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertNotEquals(expectedUrl,actualUrl);

        //assertTrue
        //beklenen bir sonucun true olduğunun kabul edilmesi gerektiği zaman kullanılır.
        // Parametre olarak iki değer alır.
        // İlk parametre de bir mesaj gönderilir ikinci parametrede ise gönderilen mesajın doğruluğu için koşul belirlenir.
        //assertFalse
        //beklenen bir sonucun false olması durumunda kullanılır.
        // İki parametre alır. Parametrelerden biri mesajdır diğeri ise koşuldur.
        // assertFalse ile koşul yerine getirilmez ise assertionError hatası fırlatır.
    }
}
