package junit5tests;

import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

public class MiscTest {
    @Test
    @Timeout(5)
    void timeout() throws InterruptedException{
        System.out.println("This is a test with timeout");
        Thread.sleep(6000);
    }

    @Test
    @Timeout(90)
    @DisplayName("This is a nice method")
    @Tag("theTag")
    void annotatedMethodOne(){
        System.out.println("This is the anotated method");
    }
    @MyAnnotation
    void customAnnotatedMethodOne(){
        System.out.println("This is the custom anotated method");
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class NestedTest{
        @BeforeAll
        void beforeAll(){
            System.out.println("Before all in nested test");
        }
        @Test
        void nestedTestMethod(){
            System.out.println("This is a nested test method");
        }
    }
}
