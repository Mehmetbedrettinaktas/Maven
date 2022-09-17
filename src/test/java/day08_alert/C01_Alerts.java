package day08_alert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Alerts {
    /*
    https://the-internet.herokuapp.com/javascript_alerts adresine gidin
    - Click for js Alert butonunu tiklayalim
    - Tkladiktan sonra cikan uyari mesajina (alerte) tamam diyelim

     */
    WebDriver driver;
    @Before
    public  void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
        public void tearDown(){
        driver.close();

    }@Test
    public void test1() throws InterruptedException {
        //https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        Thread.sleep(3000);
        // - Tkladiktan sonra cikan uyari mesajina (alerte) tamam diyelim
        driver.switchTo().alert().accept();
    }
}
