package day09_iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_iframe {
      /*
    ● Bir class olusturun: IframeTest
    ● https://the-internet.herokuapp.com/iframe adresine gidin.
    ● Bir metod olusturun: iframeTest
       ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
       ○ Text Box’a “Merhaba Dunya!” yazin.
       ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
         dogrulayin ve konsolda yazdirin
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

    }
    @Test
    public void iframeTest() throws InterruptedException {
        //  https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        // ○ “Fork me on GitHub
        //An iFrame containing the TinyMCE WYSIWYG Editor” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        WebElement iframeYazisi= driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(iframeYazisi.isDisplayed());
        System.out.println(iframeYazisi.getText());
        // ○ Text Box’a “Merhaba Dunya!” yazin.
        WebElement texBox= driver.findElement(By.id("mce_0_ifr")); // Frame'e gecis yapmadan once orayi id ile locate ettik
        driver.switchTo().frame(texBox); // Locate ettigimiz frame gecmek icin bu methodu kullaniriz
        WebElement texBoxFrame=driver.findElement(By.xpath("//p"));
        texBoxFrame.clear();
        Thread.sleep(3000);

       texBoxFrame.sendKeys("Merhaba Dunya");
        // ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
        //   dogrulayin ve konsolda yazdirin
        driver.switchTo().defaultContent();// IFrame'den cikip ana sayfaya gecmek icin bu method kullanilir.
        WebElement seleniumText= driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(seleniumText.isDisplayed());
        System.out.println(seleniumText.getText());

    }
}
