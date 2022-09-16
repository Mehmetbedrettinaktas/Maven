package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeClassAfterClass {
    /*
    BeforeClass ve AfterClass notasyonlari kullaniyorsak olusturacagimiz method'u
   mutlaka static yapmamiz gerekiyor
     */
    static WebDriver driver;
    @BeforeClass // before class olustururken method static olmak zorunda
    // before da method static degil
    public  static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
    @Test
    @Ignore("Ahmetin testi beni ilgilendirmez bu yuzden calistirmiyorum")
    // test olmasini istemedigimiz zaman @Test notusyonun altina @Ignore notasyonu kullanilir
    public void method1() throws InterruptedException {
        Thread.sleep(2000);
        driver.get("https://www.amazon.com");
    }
    @Test
    public void method2() throws InterruptedException {
        Thread.sleep(2000);
        driver.get("https://www.techproeducation.com");
    }
    @Test
    public void method3() throws InterruptedException {
        Thread.sleep(2000);
        driver.get("https://www.hepsiburada.com");

        /*
        1- befero afterda her test icin farkli browser acip kapatiyor,
        beforeClass AfterClass'ta ise tek browser'dan testleri acip kapatiyor
        2-before methodu ve afterda da her bir method icin ayri ayri calisir
        beforeClass ve AfterClass a ise once before methodu çalışır sonra diger methodlar
        calisir ve en sonunda after methodu çalışır
         */
    }
}
