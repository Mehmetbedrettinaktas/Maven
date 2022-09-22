package day11_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class C03_Odev extends TestBaseBeforeAfter {

    @Test
    public void test1() {
        // -  amazon gidin
        driver.get("https://www.amazon.com");
        //Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement arananKelime= driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        //dropdown menude 40 eleman olduğunu doğrulayın
        List<WebElement> drops=driver.findElements(By.xpath("//option"));
        System.out.println(drops.size());
        for (WebElement w:drops) {
            System.out.println(w.getText());
        }
        int dropDownList=drops.size();
        int epectedSayi=40;
        Assert.assertNotEquals(epectedSayi,dropDownList);
    }

    @Test
    public void test2() {
        //Test02
        //dropdown menuden elektronik bölümü seçin
        WebElement drops= driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        drops.click();
        WebElement arananKelime= driver.findElement(By.xpath("(//*[text()='Electronics'])[1]"));
        arananKelime.click();
        //arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys("iphone", Keys.ENTER);
        //sonuc sayisi bildiren yazinin iphone icerdigini test edin
        //ikinci ürüne relative locater kullanarak tıklayin
        //ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim
        //Test03
        //yeni bir sekme açarak amazon anasayfaya gidin
        //dropdown’dan bebek bölümüne secin
        //bebek puset aratıp bulundan sonuç sayısını yazdırın
        //sonuç yazsının puset içerdiğini test edin
        //5-üçüncü ürüne relative locater kullanarak tıklayin
        //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin  Test 4
        //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
    }
}



