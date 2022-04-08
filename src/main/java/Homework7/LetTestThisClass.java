package Homework7;

public class LetTestThisClass {
    @Test(priority = 5)
    static void test1() {
        System.out.println("test1");
    }

    @Test
    static void test2() {
        System.out.println("test2");
    }

    @Test(priority = 2)
    static void test3() {
        System.out.println("test3");
    }

    @AfterSuite
    static void after() {
        System.out.println("after test");
    }

//    @AfterSuite
//    static void after2() {
//        System.out.println("after2 test");
//    }

    @BeforeSuite
    static void before() {
        System.out.println("before test");
    }

}
