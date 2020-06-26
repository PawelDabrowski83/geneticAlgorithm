package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class ChainTest {

    @DisplayName("Should Chain equals work?")
    @ParameterizedTest(name = "{index} => expected={0}, chain={1}")
    @MethodSource("equalsArgumentsProvider")
    void equals(Chain expected, Chain chain) {
        assertEquals(expected, chain);
    }
    private static Stream<Arguments> equalsArgumentsProvider() {
        return Stream.of(
                Arguments.of(
                        new Chain(List.of(
                                new Chromosome(List.of(Gene.ZERO, Gene.ONE, Gene.ONE)),
                                new Chromosome(List.of(Gene.ONE, Gene.ZERO, Gene.ZERO)),
                                new Chromosome(List.of(Gene.ONE, Gene.ONE, Gene.ONE))
                        )),
                        new Chain(List.of(
                                new Chromosome(List.of(Gene.ZERO, Gene.ONE, Gene.ONE)),
                                new Chromosome(List.of(Gene.ONE, Gene.ZERO, Gene.ZERO)),
                                new Chromosome(List.of(Gene.ONE, Gene.ONE, Gene.ONE))
                        ))
                ),
                Arguments.of(
                        new Chain(List.of(
                                new Chromosome(List.of(Gene.ONE, Gene.ONE, Gene.ONE)),
                                new Chromosome(List.of(Gene.ONE, Gene.ONE, Gene.ZERO)),
                                new Chromosome(List.of(Gene.ONE, Gene.ONE, Gene.ONE))
                        )),
                        new Chain(List.of(
                                new Chromosome(List.of(Gene.ONE, Gene.ONE, Gene.ONE)),
                                new Chromosome(List.of(Gene.ONE, Gene.ONE, Gene.ZERO)),
                                new Chromosome(List.of(Gene.ONE, Gene.ONE, Gene.ONE))
                        ))
                ),
                Arguments.of(
                        new Chain(List.of(
                                new Chromosome(List.of(Gene.ZERO)),
                                new Chromosome(List.of(Gene.ONE, Gene.ONE, Gene.ZERO, Gene.ZERO, Gene.ZERO)),
                                new Chromosome(List.of(Gene.ONE, Gene.ZERO, Gene.ZERO, Gene.ZERO, Gene.ONE)),
                                new Chromosome(List.of(Gene.ZERO, Gene.ONE)),
                                new Chromosome(List.of(Gene.ONE, Gene.ONE, Gene.ZERO, Gene.ZERO)),
                                new Chromosome(List.of(Gene.ONE))
                        )),
                        new Chain(List.of(
                                new Chromosome(List.of(Gene.ZERO)),
                                new Chromosome(List.of(Gene.ONE, Gene.ONE, Gene.ZERO, Gene.ZERO, Gene.ZERO)),
                                new Chromosome(List.of(Gene.ONE, Gene.ZERO, Gene.ZERO, Gene.ZERO, Gene.ONE)),
                                new Chromosome(List.of(Gene.ZERO, Gene.ONE)),
                                new Chromosome(List.of(Gene.ONE, Gene.ONE, Gene.ZERO, Gene.ZERO)),
                                new Chromosome(List.of(Gene.ONE))
                        ))
                ),
                Arguments.of(
                        new Chain(List.of(
                                new Chromosome(List.of(Gene.ZERO))
                        )),
                        new Chain(List.of(
                                new Chromosome(List.of(Gene.ZERO))
                        ))
                )
        );
    }
}
