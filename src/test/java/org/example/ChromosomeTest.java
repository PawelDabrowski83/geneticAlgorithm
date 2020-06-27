package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class ChromosomeTest {

    @DisplayName("Should Chromosome equals work properly?")
    @ParameterizedTest(name = "{index} => expected={0}, chromosome={1}")
    @MethodSource("equalsArgumentsProvider")
    void equals(Chromosome expected, Chromosome chromosome) {
        assertEquals(expected, chromosome);
    }
    private static Stream<Arguments> equalsArgumentsProvider() {
        return Stream.of(
                Arguments.of(
                        new Chromosome(List.of(Gene.ONE, Gene.ZERO, Gene.ZERO, Gene.ONE)),
                        new Chromosome(List.of(Gene.ONE, Gene.ZERO, Gene.ZERO, Gene.ONE))
                ),
                Arguments.of(
                        new Chromosome(List.of(Gene.ZERO, Gene.ZERO, Gene.ONE)),
                        new Chromosome(List.of(Gene.ZERO, Gene.ZERO, Gene.ONE))
                ),
                Arguments.of(
                        new Chromosome(List.of(Gene.ONE)),
                        new Chromosome(List.of(Gene.ONE))
                ),
                Arguments.of(
                        new Chromosome(List.of(Gene.ZERO)),
                        new Chromosome(List.of(Gene.ZERO))
                )
        );
    }

    @DisplayName("Should getNumber works")
    @ParameterizedTest(name = "{index} => expected={0}, chromosome={1}")
    @MethodSource("getNumberArgumentsProvider")
    void getNumber(long expected, Chromosome chromosome) {
        assertEquals(expected, chromosome.getNumber());
    }
    private static Stream<Arguments> getNumberArgumentsProvider() {
        return Stream.of(
                Arguments.of(1, new Chromosome(List.of(Gene.ONE))),
                Arguments.of(0, new Chromosome(List.of(Gene.ZERO))),
                Arguments.of(7, new Chromosome(List.of(Gene.ONE, Gene.ONE, Gene.ONE))),
                Arguments.of(48, new Chromosome(List.of(Gene.ONE, Gene.ONE, Gene.ZERO, Gene.ZERO, Gene.ZERO, Gene.ZERO))),
                Arguments.of(13, new Chromosome(List.of(Gene.ONE, Gene.ONE, Gene.ZERO, Gene.ONE))),
                Arguments.of(31, new Chromosome(List.of(Gene.ONE, Gene.ONE, Gene.ONE, Gene.ONE, Gene.ONE)))
        );
    }
}
