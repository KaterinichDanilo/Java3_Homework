import Homework6.Task1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TestTask1 {
    static Stream<Arguments> dataForTestGetArrayAfter4() {
        return Stream.of(
                Arguments.arguments(new Integer [] {1, 7}, new Integer[] {1, 2, 4, 4, 2, 3, 4, 1, 7 }),
                Arguments.arguments(new Integer [] {}, new Integer[] {1, 2, 4, 4, 2, 4}),
                Arguments.arguments(new Integer [] {1, 7, 5, 6, 1}, new Integer[] {1, 2, 4, 4, 1, 7, 5, 6, 1})
        );
    }

    @ParameterizedTest
    @MethodSource("dataForTestGetArrayAfter4")
    void testTask1(Integer [] expected, Integer [] array) {
        Assertions.assertArrayEquals(expected, Task1.getArrayAfter4(array));
    }

    @Test
    void assertException() {
        Assertions.assertThrows(RuntimeException.class, () -> Task1.getArrayAfter4(new Integer[] {1, 2, 3}));
    }

    static Stream<Arguments> dataForTestIfArrayConsistOf1And4() {
        return Stream.of(
                Arguments.arguments(true, new Integer[] {1, 1, 1, 4, 4, 1, 4, 4}),
                Arguments.arguments(false, new Integer[] {1, 1, 1, 1, 1, 1}),
                Arguments.arguments(false, new Integer[] {4, 4, 4, 4}),
                Arguments.arguments(false, new Integer[] {1, 4, 4, 1, 1, 4, 3})
        );
    }

    @ParameterizedTest
    @MethodSource("dataForTestIfArrayConsistOf1And4")
    void testIfArrayConsistOf1And4(boolean expected, Integer [] array) {
        Assertions.assertEquals(expected, Task1.ifArrayConsistsOf1And4(array));
    }
}
