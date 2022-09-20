package day10;

import org.junit.Test;
import utilities.TastBaseBeforeClassAfterClass;

public class C02_IlkTestBaseClass extends TastBaseBeforeClassAfterClass {
    @Test
    public void test1(){
        driver.get("https://www.amazon.com");
    }
}
