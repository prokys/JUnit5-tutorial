package junit5tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TaggedTestClass {

    @BeforeAll
    void beforeAll(){
        System.out.println("..This is the before all method");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("----This is before each method");
    }

    @AfterAll
    void afterAll(){
        System.out.println("..This the after all method");
    }
    @AfterEach
    void afterEach(){
        System.out.println("----This is after each method");
    }

    @Test
    @Tag("sanity")
    void firstMethod(){
        System.out.println("This is first method");
    }
    @Test
    @Tag("sanity")
    @Tag("acceptance")
    @DisplayName("US1234 - TC12 - this method is the second one")
    void secondMethod(){
        System.out.println("This is second method");
    }
    @Test
    @Tag("acceptance")
    void thirdMethod(){
        System.out.println("This is third method");
    }

    @Tag("acceptance")
    @ParameterizedTest(name = "Run: {index} - value: {arguments}")
    @ValueSource(ints = {1,5,6})
    void intValues(int theParam){
        System.out.println("theParam = "+theParam);
    }
}
