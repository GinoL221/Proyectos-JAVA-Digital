import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BooleanSupplier;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {

    @Test
    void equalsAssertion() {
        int number = 2;
        int otherNumber = 2;

        assertEquals(number, otherNumber);
    }

    @Test
    void notEqualsAssertion() {
        int number = 2;
        int otherNumber = 3;

        assertNotEquals(number, otherNumber);
    }

    @Test
    void arrayEqualsAssertion() {
        char[] numbers = {'J', 'A', 'V', 'A'};
        char[] otherNumbers = "JAVA".toCharArray();

        assertArrayEquals(numbers, otherNumbers, "Arrays are not equal");
    }


    @Test
    void trueAssertion() {
        assertTrue(7 > 1, "7 is greater than 1");
    }

    @Test
    void trueAssertion2() {
        BooleanSupplier condition = () -> 7 > 1;
        assertTrue(condition, "7 is greater than 1");
    }

    @Test
    void falseAssertion() {
        boolean condition = 1 > 7; // false
        assertFalse(condition, "1 is not greater than 7");
    }

    @Test
    void notNullAssertion() {
        Object course = new Object();
        assertNotNull(course, "The course is not null");
    }

    @Test
    void nullAssertion() {
        Object course = null;
        assertNull(course, "The course is null");
    }

    @Test
    void SameAssertion() {
        String course = "Backend";
        Optional<String> optional = Optional.of(course);

        assertSame(course, optional.get());
    }

    @Test
    void NotSameAssertion() {
        String course = "Backend";
        String otherCourse = "POO";
        Optional<String> optional = Optional.of(otherCourse);

        assertNotSame(course, optional.get());
    }

    @Test
    void allAssertions() {
        assertAll(
                () -> assertEquals(2, 2),
                () -> assertNotEquals(2, 3),
                () -> assertArrayEquals("JAVA".toCharArray(), "JAVA".toCharArray()),
                () -> assertTrue(7 > 1),
                () -> assertFalse(1 > 7),
                () -> assertNotNull(new Object()),
                () -> assertNull(null),
                () -> assertSame("Backend", Optional.of("Backend").get()),
                () -> assertNotSame("Backend", Optional.of("POO").get())
        );
    }

    @Test
    void iterableEqualsAssertion() {
        Iterable<String> arrayList = new ArrayList<>(asList("Java", "Junit", "Test"));
        Iterable<String> linkedList = new ArrayList<>(asList("Java", "Junit", "Test"));

        assertIterableEquals(arrayList, linkedList);
    }

    @Test
    void throwsAssertion() {
        Exception exception = assertThrows(NumberFormatException.class, () -> {
            Integer.parseInt("One");
        });
    }

    @Test
    void timeOutAssertion() {
        assertTimeout(
                Duration.ofSeconds(2),
                () -> {
                    Thread.sleep(1000);
                }
        );
    }

    @Test
    void timeOutPreemptivelyAssertion() {
        assertTimeoutPreemptively(
                Duration.ofSeconds(1),
                () -> {
                    Thread.sleep(10000);
                }
        );
    }

    @Test
    void linesMatchAssertion() {
        List<String> expected = asList("Java", "Junit", "Test");
        List<String> actual = asList("Java", "Junit", "Test");

        assertLinesMatch(expected, actual);
    }
}
