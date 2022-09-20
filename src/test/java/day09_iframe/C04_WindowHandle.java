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
import java.util.ArrayList;
import java.util.List;

public class C04_WindowHandle {
    //Tests package’inda yeni bir class olusturun: WindowHandle2
    //https://the-internet.herokuapp.com/windows adresine gidin.
    //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    //Click Here butonuna basın.
    //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    //Sayfadaki textin “New Window” olduğunu doğrulayın.
    //Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.
WebDriver driver;
@Before
    public void setUp() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

}
@Test
    public void test01() throws InterruptedException {
    //https://the-internet.herokuapp.com/windows adresine gidin.
    driver.get("https://the-internet.herokuapp.com/windows");
    //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());

    //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
   // String expectedTitle = "The Internet";
    Assert.assertTrue(driver.getTitle().contains("The Internet"));
    //Click Here butonuna basın.
    driver.findElement(By.xpath("//*[text()='Click Here']")).click();
    Thread.sleep(3000);
    /*
        Bir web sitesine gittigimizde bir webelementi tikladigimizda yeni bir sekme ya da pencere acilirsa
    buyeni acilan sekmenin handle degerini bulabilmek icin driver.getWindowHandles() methodunu bir ArrayList'e
    atip butun sayfalarin listesine ulasabiliriz. Ilk actigim pencerenin index'i 0'dır,ikinci acilan sekmenin index'i 1'dir
    ve ikinci acilan pencere veya sekmede islem yapabilmek icin
    driver.switchTo().window(ListAdi.get(1)) methodu kullaniriz
     */
    List<String> windowList=new ArrayList<>(driver.getWindowHandles());
    System.out.println("window handel degerleri : "+windowList);
    driver.switchTo().window(windowList.get(1));
    /* 2. yol
    Set<String> windowHandleseti= driver.getWindowHandles();
        System.out.println(windowHandleseti);
        String ikinciSayfaWindowHandleDegeri="";
        for (String each: windowHandleseti) {
            if (!each.equals(ilkSayfaWindowHandleDegeri)){
                ikinciSayfaWindowHandleDegeri=each;
            }
        }
     */

    //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    Assert.assertEquals(driver.getTitle(),"New Window");

    //Sayfadaki textin “New Window” olduğunu doğrulayın.
   Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());
   Thread.sleep(3000);
    //Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.
    driver.switchTo().window(windowList.get(0));
    Assert.assertEquals("The Internet",driver.getTitle());

}
@After
    public void tearDown() {
    driver.quit();

}

}

