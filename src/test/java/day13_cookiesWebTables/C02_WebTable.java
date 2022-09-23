package day13_cookiesWebTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class C02_WebTable extends TestBaseBeforeAfter
{
    @Test
    public void test1() {
          // Bir class oluşturun : C02_WebTables
        //login( ) metodun oluşturun ve oturum açın.

        //https://www.hotelmycamp.com/admin/HotelRoomAdmin adresine gidin
        login();
        System.out.println("************");
        //Username : manager
        //Password : Manager1!

        //table( ) metodu oluşturun
        table();
        System.out.println("**************");
        //printRows( ) metodu oluşturun //tr
        printRows();


    }

    private void printRows() {
        //table body’sinde bulunan toplam satir(row) sayısını bulun.
       List <WebElement> satirSayisi= driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Tablodaki satir sayisi: "+satirSayisi.size());
        //Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        satirSayisi.forEach(t-> System.out.println(t.getText()));
        //4.satirdaki(row) elementleri konsolda yazdırın.
        System.out.println(driver.findElement(By.xpath("//tbody//tr[4]")).getText());

    }

    private void table() {
        //Tüm table body’sinin boyutunu(sutun sayisi) bulun.
        List<WebElement> sutunSayisi= driver.findElements(By.xpath("//thead//tr//th"));
        System.out.println("Sutun sayisi : "+sutunSayisi.size());
        /*
        Tabloda<table> tag'i altinda tablonun basligini gosteren <thead> tagi bulunur.
        Eger baslikta satir<row> varsa <thead> tag'i altinda <tr> tagi vardir. Ve basliktaki sutunlara yani
        hucrelere(cell) de <th> tag'i ile ulasilir.
        basligin tablodaki verilere <tbody> tag'i ile altindaki satirlara<tr> tag'i
        ile sutunlara yani hucrelere <td> tag'i ile ulasiriz.

        table row =tr
        table header = th
        table data= td
         */

        //Tüm table body’sinin boyutunu(sutun sayisi) bulun.
        WebElement basliklar=driver.findElement(By.xpath("//thead//tr"));
        System.out.println("Basliklar : "+ basliklar.getText());

        //Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        WebElement body= driver.findElement(By.xpath("//tbody"));
        System.out.println("Tum body : " +body.getText());

    }

    private void login() {
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
      //  driver.findElement(By.xpath("//input[@id='UserName']")).click();
        Actions actions=new Actions(driver);
        WebElement username= driver.findElement(By.xpath("//input[@id='UserName']"));
        actions.click(username).sendKeys("manager").
                sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();
    }
}
