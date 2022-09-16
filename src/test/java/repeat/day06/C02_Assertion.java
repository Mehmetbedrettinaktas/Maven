package repeat.day06;

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
    /*
    Amazon sayfasina gidelim ve 3 farkli test methodunu olusturalim
    1- Url'nin amazon icerdigini test edelim
    2- Title'in facebook icermedigini test edelim
    3- sol ust kosede amazon logosunun gorundugunu test edelim

     */
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //Amazon sayfasina gidelim ve 3 farkli test methodunu olusturalim
        driver.get("https://www.amazon.com");

    }
    @AfterClass
    public static void tearDown() {
         driver.close();
    }

    @Test
    public void test1(){
        // 1- Url'nin amazon icerdigini test edelim
        String expectedUrl = "amazon";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));

    }
    @Test
    public void test2(){
        //2- Title'in facebook icermedigini test edelim
        String actualTitle =  driver.getTitle();
        String expectedTitle ="facebook";
        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }
    @Test
    public void test3(){
        // 3- sol ust kosede amazon logosunun gorundugunu test edelim
        WebElement logo= driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logo.isDisplayed());

    }
    @Test
    public void test4() {
        // 1- Url'nin https://www.facebook.com oldugunu test edelim
        String expectedUrl = "https://www.facebook.com";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertNotEquals(expectedUrl,actualUrl);
        /*
        feild oldugu zaman asagidaki sonucu aliyoruz.
         Assert.assertEquals("Url'ler esit degil",expectedUrl,actualUrl);
        Expected :https://www.facebook.com
        Actual   :https://www.amazon.com/
        <Click to see difference>
         */
    }
}
