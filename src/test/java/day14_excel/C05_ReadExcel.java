package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C05_ReadExcel {
    @Test
    public void readExcelTest() throws IOException {
        //- Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        //- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu); //Olusturmuş olduğumuz dosyayı sistemde işleme alır
        //- Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //- WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);

        //-sayfa 2'ye gidip satir sayisinin 4, kullanilan satir sayisinin ise 15 oldugunu test edin

        int sonsatir= workbook.getSheet("Sayfa2").getLastRowNum();
        System.out.println("sonsatir = " + sonsatir);
        int expectedLastRow=14;
        Assert.assertEquals(expectedLastRow,sonsatir);

        int kullanilanSatir=workbook.getSheet("Sayfa2")
                .getPhysicalNumberOfRows(); // Excel tablosundaki kullanilan satir sayisni bu method ile aliriz
        int expectedKullanilansatir=5;
        Assert.assertEquals(expectedKullanilansatir,kullanilanSatir);

    }
}
