package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import javax.swing.*;

public class C03_Actions extends TestBaseBeforeAfter {
    @Test
    public void test1(){
        // amazon sayfasina gidelim
        // account menusunden creat a list linkini tiklayalim
        driver.get("https://www.amazon.com");
      WebElement accountList= driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        Actions actions=new Actions(driver);
        actions.moveToElement(accountList).perform();
        /*
        Bir web sitesinde maus ile acilan bir webelemntine ulasmak istersek
        ations.moveToElement() methodunu kullanmamiz gerekir, aksi takdirde HTML
        kodlari arasinda webelemnti bulur ama ulasamadigi icin
        ElementNotInteractableException: element not interactable: hatasini aliriz
         */
        driver.findElement(By.xpath("//*[text()='Create a List']")).click();

    }
}
