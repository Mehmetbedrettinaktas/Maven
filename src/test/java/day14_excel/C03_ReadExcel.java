package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {
    @Test
    public void test() throws IOException {
        /*
        belirtilen satirNo ve sutunNo degerlerini parametre olarak alip o cell'deki
        datayi konsola yazdiralim sonucu konsolda yazanla yayni oldugunu dogrulayalim
         */
        int satir=12;
        int sutun=2;
        //- Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        //- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);
        //- Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //- WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis); // excel'imizi olusturuyoruz
        String actualData=workbook.getSheet("Sayfa1")
                .getRow(satir-1)
                .getCell(sutun-1)
                .toString();
        // index 0 dan basladigi icin bizden istenen satira ulasabilmek icin bir eksigini alir.
        System.out.println(actualData);

        String konsoldaYazan="Baku";
        Assert.assertEquals(konsoldaYazan,actualData);




    }
}
