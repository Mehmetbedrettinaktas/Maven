package day11_actions;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;


public class C04_FileExists  {

    @Test
    public void test1(){
        System.out.println(System.getProperty("user.di")); // Suanki icinde bulundugum yolu gosterir
        System.out.println(System.getProperty("user.home")); // Gecerli kullanicinin ana dizinini verir

        /*
        String farkliBolum = System.getProperty("user.home");
        //"C:\Users\Lenovo\OneDrive\Masaüstü\text.txt" --> masa üstündeki dosyanın yolu
        String ortakBolum = "\\OneDrive\\Masaüstü\\tex.txt";
        String masaUstuDosyaYolu = farkliBolum+ortakBolum; // Masaüstündeki dosya yolunu gösterir
        System.out.println(masaUstuDosyaYolu); //C:\Users\Lenovo\OneDrive\Masaüstü\text.txt
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        */

       // String farkliBolum =System.getProperty("user.home");
        // "C:\Users\Computer\Desktop\deneme.txt"  --> masa ustundeki dosya yolu

        String dosyaYolu="C:\\Users\\Computer\\Desktop\\deneme.txt";
        // System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        /*
         bir web sitesinden indirdiğimiz yada windows içinde oluşturduğumuz dosyanın indiğini yada
         orda olduğunu test edebilmem için o dosyanın üzerine shift tuşuna basılı olarak sağ click
        yapıp dosyanın yolunu kopyalayıp bir String değişkene atarız ve dosyayı doğrulamak için
       Assert.assertTrue(Files.exists(Paths.get(dosyaYolu))); bu methodu kullanirim
         */



    }
}
