package day15_readExcel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C03_DeleteExcel {
    @Test
    public void deleteExceltest() throws IOException {
        //-Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);
        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook = WorkbookFactory.create(fis);
        //-WorkbookFactory.create(fileInputStream)
        Sheet sheet = workbook.getSheet("Sayfa1");
        //-Sheet objesi olusturun workbook.getSheetAt(Sayfa1)
        Row row = sheet.getRow(3);

        //-Row objesi olusturun sheet.getRow(3)
        Cell cell = row.getCell(3);
        //-Cell objesi olusturun row.getCell(3)
        row.removeCell(cell);
        System.out.println(workbook.getSheet("Sayfa1").getRow(3).getCell(3));

      //  String  actualData = workbook
      //  .getSheet("Sayfa1")
      //  .getRow(3)
      //  .getCell(3)
      //  .toString();
        /*
        workbook.getSheet("Sayfa1").getRow(3).getCell(3).getStringCellValue().isBlank();

        row.removeCell(cell);
        System.out.println(workbook.getSheet("Sayfa1").getRow(3).getLastCellNum());

        */
        /*
        Bir cell'deki veriyi silmek icin row objesine ihtiyac vardir.
        row objesi ile removeCell() methodunu kullanarak cell objesi ile bellirtigimiz
        cell degerini silebiliriz
         */


        //-3. Satır 3. Cell'deki veriyi silelim
        FileOutputStream fos=new FileOutputStream(dosyaYolu);
        workbook.write(fos);

        //-Silindiğini test edin
        String expectedData="Cezayir";
        String actualData=workbook.getSheet("Sayfa1").getRow(3).getCell(3).toString();
        Assert .assertEquals(expectedData,actualData);
    }
}
