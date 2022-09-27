package practice.day02;

import org.junit.*;

public class C02_JUnit {
    @BeforeClass
    public static void setUp(){
        System.out.println("Before class");
        // her class'ta ilk calisir. 1 kere calisir
    }
    @AfterClass
    public static void afterClass() {
        System.out.println("AfterClass");

    }
    @Before
    public void before(){
        System.out.println("before");
        // her testen once calisir
    }
    @After
    public void tearDown(){
        System.out.println("After");
        // her testen sonra calisir
    }
    @Test
    public void test1(){
        System.out.println("Test 01");
    }
    @Test
    public void test2(){
        System.out.println("Test 02");
    }
    @Test
    public void test3(){
        System.out.println("Test 03");

    }
}
