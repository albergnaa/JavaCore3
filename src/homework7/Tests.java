package homework7;

public class Tests {

    @BeforeSuite
    public void prepare() {
        System.out.println("Подготовка");
    }

    @Test(priority = 7)
    public void test3() {
        System.out.println("Test3, приоритет:7");
    }

    @Test(priority = 2)
    public void test1() {
        System.out.println("Test1, приоритет:2");
    }

    @Test(priority = 10)
    public void test4() {
        System.out.println("Test4, приоритет:10");
    }

    @Test
    public void test2() {
        System.out.println("Test2, приоритет:default(5)");
    }

    @AfterSuite
    public void clean() {
        System.out.println("Зачистка");
    }
}
