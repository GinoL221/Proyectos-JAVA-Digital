import org.junit.jupiter.api.*;

public class CicloVidaTest {

    // Se ejecuta antes de todo el ciclo de vida de las pruebas
    @BeforeAll
    static void initAll() {
        System.out.println("initAll");
    }

    // Se ejecuta después de todo el ciclo de vida de las pruebas
    @BeforeEach
    void init() {
        System.out.println("init");
    }

    // Se ejecuta antes de cada prueba
    @Test
    void regular_testing_method(){
        System.out.println("regular_testing_method");
    }

    // Se ejecutaría después de cada prueba, pero esta desabilitada
    @Test
    @Disabled
    void disabled_test(){
        System.out.println("disabled_test");
    }

    // Se ejecuta después de cada prueba
    @AfterEach
    void tearDown() {
        System.out.println("tearDown");
    }

    // Se ejecuta después de todo el ciclo de vida de las pruebas
    @AfterAll
    static void tearDownAll() {
        System.out.println("tearDownAll");
    }

    // Se ejecuta antes de todo el ciclo de vida de las pruebas con un tag
    @Tag("unit")
    @Test
    void test1(){
        System.out.println("test1");
    }

    @Tag("otherTest")
    @Test
    void test2(){
        System.out.println("test2");
    }
}
