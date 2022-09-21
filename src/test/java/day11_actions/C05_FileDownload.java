package day11_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBeforeAfter;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_FileDownload extends TestBaseBeforeAfter {
    /*
        Iki tane metod oluşturun : isExist( ) ve downloadTest( )
        downloadTest ( ) metodunun icinde aşağıdaki testi yapalim:
        https://the-internet.herokuapp.com/download adresine gidelim.
        test.txt dosyasını indirelim
        Ardından isExist( )  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
     */
    @Test
    public void isExist() throws InterruptedException {
        //  https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //  test.txt dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='test.txt']")).click();
        Thread.sleep(3000);
        //Ardından isExist( )  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
        String dosyaYolu="C:\\Users\\Computer\\Downloads\\test.txt";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu))); // exists --> var olan
        // indirilip indirilmediğini test edelim
        System.out.println(Files.exists(Paths.get(dosyaYolu)));

    }

}
