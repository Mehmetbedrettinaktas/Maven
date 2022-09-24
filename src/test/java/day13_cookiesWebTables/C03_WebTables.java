package day13_cookiesWebTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class C03_WebTables extends TestBaseBeforeAfter {
    @Test
    public void test() {

        // Bir onceki class'daki adrese gidelim
        // Login() methodunu kullanarak sayfaya giris yapalim
        login();
        int satir=3;
        int sutun=4;
        // input olarak verilen satir sayisi ve sutun sayisina sahip cell'deki text'i yazdiralim
        WebElement cell =driver.findElement(By.xpath("//tbody//tr["+satir+"]//td["+sutun+"]"));
        // tbody olursa  --> td olur
        //thead --> olursa th olur
        // Thead de satır için tr, sutun için th
        //Tbody de satır için tr, sütun için td

         /*
            Tabloda<table> tagı altinda tablonun basligini gösteren <thead> tag'i bulunur.
            Eger baslikta satir(row) varsa <thead> tag'i altinda <tr> (satir-row) tagi vardir.
            Ve basliktaki sutunlara yani hucrelere(cell) de <th> tag' ile ulasilir.
            Basligin altindaki verilere <tbody> tag'i ile altindaki satirlara(row) <tr> tag'i ile
            sutunlara yani hucrelere<td> tag'i ile ulasilir.
        */
        System.out.println("3. satir 4. sutundaki text :"+ cell.getText());
        // WebElement tekilHucre = driver.findElement(By.xpath("//tbody//tr[6]//td[4]"));
        // Price basligindaki tum numaralari yazdiriniz
        List<WebElement> pricebasligi=driver.findElements(By.xpath("//tbody//tr//td[6]"));
        for (WebElement each:pricebasligi
             ) {
            System.out.println(each.getText());
        }

    }
    public void login() {
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        //  driver.findElement(By.xpath("//input[@id='UserName']")).click();
        Actions actions=new Actions(driver);
        WebElement username= driver.findElement(By.xpath("//input[@id='UserName']"));
        actions.click(username).sendKeys("manager").
                sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();
    }
}
