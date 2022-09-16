package repeat.day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_RadioButton {
    /*
    Bir class oluşturun : RadioButtonTest
    Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    https://www.facebook.com adresine gidin
    Cookies’i kabul edin
    “Create an Account” button’una basin
    “radio buttons” elementlerini locate edin
    Secili degilse cinsiyet butonundan size uygun olani secin

     */
  static   WebDriver driver;
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
    public void test1(){
      // https://www.facebook.com adresine gidin
        // Cookies’i kabul edin
        driver.get("https://www.facebook.com");

    }
    @Test
    public void test2(){
      //  “Create an Account” button’una basin
        driver.findElement(By.xpath("(//*[@role='button'])[2]")).click();
    }
    @Test
    public void test3(){
         // “radio buttons” elementlerini locate edin

        WebElement femaleButton = driver.findElement(By.xpath("//input[@value='1']"));
        WebElement maleButton = driver.findElement(By.xpath("//input[@value='2']"));
        WebElement customButton = driver.findElement(By.xpath("//input[@value='-1']"));
        // Secili degilse cinsiyet butonundan size uygun olani secin
        if (!maleButton.isSelected()){
            maleButton.click();
        }
    }
}
