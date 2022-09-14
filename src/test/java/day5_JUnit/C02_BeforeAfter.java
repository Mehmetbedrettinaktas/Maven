package day5_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforeAfter {
    /*
    @Before : Önce ; @After : Sonra Demek. @Test kısmında yazdığımız methodlar;
    çalışmaya başlamadan önce @Before yazan method çalışır;
    sonra kendisi çalışır ve en son olarak ta @After da yazılan method çalışır..
    .Bu durum her @Test methodunda aynı şekilde çalışır.
    @After ve @Before methodlarının nerde yazıldığının önemi yoktur
     */
    WebDriver driver;
    @After
    //After notasyonu her testten sonra çalışır
    public void tearDown() { // after methodu icin kullanilan method adi tearDown kullanilir.
        driver.close();
    }
    @Before
    // Before notasyonu her testten önce çalışır
    public void setUp(){ // before methodu icin kullanilan method adi setUp kullanilir.
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void method1() {
        //1 defa before methodu çalışır
        driver.get("https://amazon.com");
        //1 defa da after methodu çalışır
    }
    @Test
    public void method2() {
        //1 defa before methodu çalışır
        driver.get("https://techproeducation.com");
        //1 defa da after methodu çalışır
    }
    @Test
    public void method3() {
        //1 defa before methodu çalışır
        driver.get("https://hepsiburada.com");
        //1 defa da after methodu çalışır
    }

}
