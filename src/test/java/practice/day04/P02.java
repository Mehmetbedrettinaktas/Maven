package practice.day04;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBaseBeforeAfter;

import java.nio.file.Files;
import java.nio.file.Paths;

public class P02 extends TestBaseBeforeAfter {
    @Test
    public void test() {
        //Verify that we have pom.xml file in our project => please try in 4 min s
        String dosyaYolu = "C:\\Maven\\pom.xml";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        /*
          String actualData = "pom.xml";
    String expectedData = System.getProperty("pom.xml.filename");

    Assert.assertEquals(actualData, expectedData);


        String dosyaYolu="pom.xml";
        FileInputStream fis = new FileInputStream(dosyaYolu);
     Assert.assertNotNull(fis);


         String dosyaYol = "pom.xml";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYol)));
         */
    }
}
