package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C04_ReadExcel {
    @Test
    public void readExceltest() throws IOException {
        //-Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);
        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //-WorkbookFactory.create(fileInputStream)
        Workbook workbook= WorkbookFactory.create(fis);

        //-Turkce baskentler sutununu yazdiralim
        int sonSatir =workbook.getSheet("Sayfa1").getLastRowNum();
        // getLastRowNum(); methodu bize excel sayfasindaki tum satir numarasini verir
        System.out.println(sonSatir);
        String turkceBaskentler="";
        for (int i = 0; i <=sonSatir ; i++) {
            if (i==0){
                System.out.println("Başkent (Türkçe)");
            }else {
                turkceBaskentler=workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
                System.out.println(i+". baskent "+turkceBaskentler);
            }
        }
        /*
        List<String> list=new ArrayList<>();
    for (int i = 0; i <=sonsatir ; i++) {
        list.add(workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString());
    }
        list.forEach(t-> System.out.println(t));





        Exceldeki bir dosyaya ve dosyadaki bir bölüme ulaşmak istediğimizde
        uygulayacağımız aşamalar :
        Ara-->dosyaYolu      --> String dosyaYolu="src/resources/ulkeler.xlsx";
        Windows Gezgini ile ac- ->FileInputStream    --> FileInputStream fis = new FileInputStream(dosyaYolu);
        Excel i ac              -->Workbook        --> Workbook workbook = WorkbookFactory.create(fis)
        workbook olusturduktan sonra :
        String actualData = workbook.
                        getSheet("Sayfa1")
                        .getRow(3)
                        .getCell(3)
                        .toString();
        Sayfa1 e git-->Sheet    --> getSheet()
        Satiri bul-->Row       --> getRow()
        Sutunu bul-->Cell     --> getCell()
        Secilen bolumu getir  --> toString()
         */
    }
}
