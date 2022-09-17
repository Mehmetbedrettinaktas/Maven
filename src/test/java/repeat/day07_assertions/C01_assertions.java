package repeat.day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_assertions {
    /*
    Bir Class olusturalim YanlisEmailTesti
    http://automationpractice.com/index.php sayfasina gidelim
    Sign in butonuna basalim
    Email kutusuna @isareti olmayan bir mail yazip enter’a
    bastigimizda “Invalid email address” uyarisi ciktigini test edelim
 */
     WebDriver driver;
    @Before
    public  void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public  void tearDown() {
        // driver.close();
    }
    @Test
    public void test1(){
        //  http://automationpractice.com/index.php sayfasina gidelim
        driver.get("http://automationpractice.com/index.php");
        // Sign in butonuna basalim
        driver.findElement(By.xpath("//*[@class='login']")).click();

        //   Email kutusuna @isareti olmayan bir mail yazip enter’a
      WebElement emailKutusu=  driver.findElement(By.xpath("//*[@id='email_create']"));
      emailKutusu.sendKeys("aktas.com");
      WebElement creatButonu= driver.findElement(By.xpath("//*[@value='Create an account']"));
      creatButonu.click();

      //bastigimizda “Invalid email address” uyarisi ciktigini test edelim
      Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Invalid email address.']")).isDisplayed());
    }
}
