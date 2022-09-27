package practice.day04;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P01 extends TestBaseBeforeAfter {


    @Test
    public void test1() throws InterruptedException {
        // go to the URL https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        // ikinci emojiye tıklayın (hayvan emojisini seçin)
        WebElement iframe= driver.findElement(By.xpath("//*[@id='emoojis']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();

        // //div[@class='mdl-tabs__panel is-active']/div/img = //div[@class='mdl-tabs__panel is-active']//img
        // Atladigimiz tag sayısınca // koymak gerekir mi
        // Çift olunca çoklu tag' atlama mi sayılı

        // tüm hayvan emojilerine tıklayın
      List<WebElement> animalsEmojis= driver.findElements(By.xpath("//div[@class='mdl-tabs__panel is-active']//img"));
     //  for (WebElement w:animalsEmojis) {
     //      w.click();
     //  }
     //  // 2. Yol lambda
        animalsEmojis.forEach(t->t.click());

        // iframe den girdikten sonra cikmayi unutmamiz gerekiyor.
        driver.switchTo().defaultContent();
        /*
        driver.findElement(By.xpath("mdl-textfield mdl-js-textfield mdl-textfield--floating-label is-upgraded")).sendKeys("zek");
        actions.sendKeys(Keys.TAB).sendKeys("ab").sendKeys(Keys.TAB).sendKeys("ab").sendKeys(Keys.TAB)
        .sendKeys("ab").sendKeys(Keys.TAB).sendKeys("as").sendKeys(Keys.TAB).sendKeys("ze")
         }

         driver.findElement(By.cssSelector("#text")).
        sendKeys("asd", Keys.TAB,"asd",Keys.TAB,"asd",Keys.TAB,"asd",
                Keys.TAB,"asd",Keys.TAB,"asd",Keys.TAB,"asd",Keys.TAB,"asd");

          List<WebElement>metinList=driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));
        List<String>metin=new ArrayList<>(Arrays.asList("Türkiyenin","en"
        ,"büyük","klübü","Galatasaray'ın","harika","forveti","Icardi","Cok iyi degil mi?","",""));


         */

        // formu doldurun (dilediğinizi yazabilirsiniz)
        List<WebElement>boxes=   driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));
        Thread.sleep(3000);
        //bu listi kullanarak her bir webelementi kolayca boxes listinde bulunan webelementilerimize gonderebilecegiz
        List<String> text=new ArrayList<>(Arrays.asList("bu","listi","kullanarak","her","bir","webelement","kolayca","boxes","l","b","w"));
        for (int i = 0; i <boxes.size() ; i++) {
            boxes.get(i).sendKeys(text.get(i));
        }
        Thread.sleep(3000);
        // 2. yol lambda
        //  driver.findElements(By.cssSelector("input[class=\"mdl-textfield__input\"]")).forEach(t->t.sendKeys(faker.name().name()));
        Thread.sleep(3000);
        // apply butonuna tıklayın
        driver.findElement(By.xpath("//button[@id='send']")).click();

    }
}
