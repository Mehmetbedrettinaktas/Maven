package day08_alert;

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

public class C02_Alerts {

    /*
bir web sitesine girdigimizde karsımıza bir uyarı mesajı yada bir buttona tıkladığımızda bir uyarı cıkabilir
eğer bu uyarıya incele(mause sağ-tik inspect) yapabiliyorsak bu tür alert lere html alert denir.
ve istedigimiz locate'i alabiliriz. Ama gelen uyarı kutusuna müdahale (sağ tik inspect ile) edemiyorsak
bu tür alertlere  js alert denir.
js alert'lere müdahale edebilmek icin

-- tamam ya da ok icin
driver.switchTo().alert().accept();

--iptal icin
driver.switchTo().alert().dismiss();

--alert icindeki mesajı almak icin
driver.switchTo().alert().getText();

--alert bizden bir metin istiyorsa
driver.switchTo().alert().sendKeys("");

methodları kullanilir!!

 */

    /*
 ● Bir class olusturun: Alerts
 ● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
 ● Bir metod olusturun: acceptAlert
 ○1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
 “You successfully clicked an alert” oldugunu test edin.
 ● Bir metod olusturun: dismissAlert
 ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
 “successfuly” icermedigini test edin.
 ● Bir metod olusturun: sendKeysAlert
 ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
 tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın
  */
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

    }
    @After
    public void tearDown(){
    // driver.close();
    }
    @Test
    public void acceptAlert() throws InterruptedException {
        // ○1. butona tıklayın, uyarıdaki OK(tamam) butonuna tıklayın ve result mesajının
        // “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        WebElement mesaj= driver.findElement(By.xpath("//*[@id='result']"));
        String actualmesaj=mesaj.getText();
        String expectedMesaj="You successfully clicked an alert";
        Assert.assertEquals(expectedMesaj,actualmesaj);
    }
    @Test
    public void test2() throws InterruptedException {
        //  2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın
        //  ve result mesajının  “successfuly” icermedigini test edin.
        // https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        // Alert uzerindeki mesaji yazdirin
        System.out.println("Ikinci buttonun alert yazisin: " +driver.switchTo().alert().getText());
        Thread.sleep(3000);
        driver.switchTo().alert().dismiss();

        String actualMesaj= driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedMesaj="successfuly";
        Assert.assertFalse(actualMesaj.contains(expectedMesaj));
    }
    @Test
    public void test3(){
        // 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK(tamam) butonuna
        // tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        // Alert uzerindeki mesaji yazdirin
        System.out.println("3.cü Buttonun alert mesaji: " +driver.switchTo().alert().getText());
        driver.switchTo().alert().sendKeys("mehmet");
        driver.switchTo().alert().accept();
        String actualMesaj=driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedMesaj="mehmet";
        Assert.assertTrue(actualMesaj.contains(expectedMesaj));
    }

}
