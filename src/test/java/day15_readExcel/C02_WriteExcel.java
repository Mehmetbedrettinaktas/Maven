package day15_readExcel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel {
    @Test
    public void readExcelTest() throws IOException {
        // Yeni bir Class olusturalim WriteExcel

        //Yeni bir test method olusturalim writeExcelTest()
        //Adimlari takip ederek 1.satira kadar gidelim
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        // 5.hucreye yeni bir cell olusturalim Olusturdugumuz hucreye “Nufus” yazdiralim
        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("Nufus");
        // 2.satir nufus kolonuna 1500000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(1).createCell(4).setCellValue("1500000");
        //10.satir nufus kolonuna 250000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(9).createCell(4).setCellValue("250000");
        //15.satir nufus kolonuna 54000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(14).createCell(4).setCellValue("54000");
        //Dosyayi kaydedelim
        FileOutputStream fos=new FileOutputStream(dosyaYolu); // dosyamizi akistan cikariyoruz
        // Excel dosyamiza veri girisi yaptiktan sonra dosyayi akisa aldigimiz gibi sonlandirmamiz gerekir.
        // sonrasindada workbook onjemize kayit etmemiz gerekir
        workbook.write(fos);// Write methodu ile sonlandirmamiz islemi workbook'a yazdirdik
        // 10)Dosyayi kapatalim
        fis.close();
        fos.close();
        workbook.close();


    }
}
