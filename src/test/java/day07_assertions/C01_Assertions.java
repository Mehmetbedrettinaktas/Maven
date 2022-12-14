package day07_assertions;

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

public class C01_Assertions {
    /*
        Bir Class olusturalim YanlisEmailTesti
        http://automationpractice.com/index.php sayfasina gidelim
        Sign in butonuna basalim
        Email kutusuna @isareti olmayan bir mail yazip enter’a
        bastigimizda “Invalid email address” uyarisi ciktigini test edelim
     */
   static WebDriver driver;
   @BeforeClass
    public static void setUp(){
       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
   }
   @AfterClass
    public static void tearDown() {
      // driver.close();
   }
   @Test
    public void test1() throws InterruptedException {
       // http://automationpractice.com/index.php sayfasina gidelim
       driver.get("http://automationpractice.com/index.php");
       // Sign in butonuna basalim
       driver.findElement(By.xpath("//*[@class='login']")).click();
       // Email kutusuna @isareti olmayan bir mail yazip enter’a
       WebElement emailKutusu= driver.findElement(By.xpath("//*[@id='email_create']"));
       emailKutusu.sendKeys("mehmet.com");
       driver.findElement(By.xpath("//*[@class='icon-user left']")).click();
       Thread.sleep(5000);
       // bastigimizda “Invalid email address” uyarisi ciktigini test edelim
       Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Invalid email address.']")).isDisplayed());
       // mehmet.com kismini degistirecegim
   }
}
