package day12_synchronization;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C02_UploadFile extends TestBaseBeforeAfter {
    @Test
    public void test1() throws InterruptedException {
        // Tests packagenin altina bir class oluşturun : C05_UploadFile
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        // 1. adim chooseFile butonunu locate edelim
        WebElement dosyaSecButonu= driver.findElement(By.xpath("//*[@id='file-upload']"));
        // 2. adim yuklenecek dosyanin dosya yolunu olusturalim   "C:\Users\Computer\Downloads\test.txt"
        String yuklenecekDosya="C:\\Users\\Computer\\Downloads\\test.txt";
        //String farkliKisim=System.getProperty("user.home");
        // ben downlands taki LambdaTest.txt yukledim
       // String ortakKisim="\\Downloads\\LambdaTest.txt";
        //String yuklenecekDosya =farkliKisim+ortakKisim;

        /*
        Dosyasec butonuna direk click yapamayabiliriz çünkü windows'a müdahaleye izin vermeyebilir
        Bu yüzden Dosyasec butonunu direk locate edip sendKeys() methodu
        ile string değişkene atadığımız dosya yolumuzu
        göndeririz.
         */
        // 3. Adim sendKeys ile dosya yolunu, secme butonuna yollayalim

        dosyaSecButonu.sendKeys(yuklenecekDosya);
        Thread.sleep(5000);

        //5. Upload butonuna basalim.
        driver.findElement(By.xpath("//input[@id='file-submit']")).click();
        //6. “File Uploaded!” textinin goruntulendigini test edelim
        WebElement yaziElementi= driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(yaziElementi.isDisplayed());
    }
}
