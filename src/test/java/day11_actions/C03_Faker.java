package day11_actions;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C03_Faker extends TestBaseBeforeAfter {
    @Test
    public void test1() throws InterruptedException {

        // "https://facebook.com"  Adresine gidin
        driver.get("https://facebook.com");
        driver.findElement(By.xpath("//*[text()='Temel ve isteğe bağlı çerezlere izin ver']")).click();
        //“create new account”  butonuna basin
        driver.findElement(By.xpath("//*[text()='Yeni Hesap Oluştur']")).click();

        // faker class'i kullanmak icin mvn repository.com adresinden java faker kütüphanesinin aratir
        // ve en cok kullanilani pom.xml dosyamiza ekleriz
        // ve faker class'indan bir obje olusturup email icin faker.internet methodunu kullanarak
        // emailAdress() methodunu seceriz
        // password icinde ayni internet methodunu kullaniriz
        // isim ve soyisimler icin faker.name() methodu ile firstname() ve lastname() methodunu kullaniriz
        // faker claas'ini kullanma amacimiz form dordurmamiz gereken sitelerde defalarca kendi üretecegimiz
        // veriler yerine bizim icin random veriler üretir ve isimizi kolaylastirir


        //“firstName” giris kutusuna bir isim yazin
        Faker faker=new Faker();
        WebElement isimKutusu = driver.findElement(By.xpath("//input[@name='firstname']"));
        Actions actions = new Actions(driver);

        String fakeMail=faker.internet().emailAddress(); // ayni email adresini girmesi icin String bir degiskene atama yaptik
        actions.click(isimKutusu)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(fakeMail)
                .sendKeys(Keys.TAB)
                .sendKeys(fakeMail)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("10")
                .sendKeys(Keys.TAB)
                .sendKeys("Mayis")
                .sendKeys(Keys.TAB)
                .sendKeys("2000")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();
        Thread.sleep(5000);

        //Sayfayi kapatin
        driver.close();
    }
}
