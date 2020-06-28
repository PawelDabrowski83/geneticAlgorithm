package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class GeneUtilsTest {

    @DisplayName("Should randomizeGene work")
    @ParameterizedTest(name = "{index} => expected={0}, seed={1}")
    @MethodSource("randomizeGeneArgumentsProvider")
    void randomizeGene(Gene expected, int seed) {
        Random random = new Random(seed);
        random.nextInt();
        assertEquals(expected, GeneUtils.randomizeGene(random));
    }
    private static Stream<Arguments> randomizeGeneArgumentsProvider() {
        return Stream.of(
                Arguments.of(Gene.ZERO, 1),
                Arguments.of(Gene.ZERO, 2),
                Arguments.of(Gene.ONE, 4),
                Arguments.of(Gene.ZERO, 13),
                Arguments.of(Gene.ONE, 21),
                Arguments.of(Gene.ONE, 111)
        );
    }
}
