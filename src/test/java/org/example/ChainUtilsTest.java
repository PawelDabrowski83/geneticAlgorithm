package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class ChainUtilsTest {

    @DisplayName("Should randomizeChain() work?")
    @ParameterizedTest(name = "{index} => expectedSize={0}, orderedSize={1}")
    @MethodSource("randomizeChainArgumentsProvider")
    void randomizeChain(int expectedSize, int orderedSize) {
        assertEquals(expectedSize, ChainUtils.randomizeChain(orderedSize).chromosomes.size());
    }
    private static Stream<Arguments> randomizeChainArgumentsProvider() {
        return Stream.of(
                Arguments.of(3, 3),
                Arguments.of(10, 10),
                Arguments.of(1, 1),
                Arguments.of(6, 6)
        );
    }
}
