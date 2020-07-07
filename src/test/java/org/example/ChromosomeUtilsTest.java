package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class ChromosomeUtilsTest {

    @DisplayName("Should randomizeChromosome() work")
    @ParameterizedTest(name = "{index} => expected={0}, length={1}, seed={2}")
    @MethodSource("randomizeChromosomeArgumentsProvider")
    void randomizeChromosome(Chromosome expected, int length, int seed) {
        Random random = new Random(seed);
        assertEquals(expected, ChromosomeUtils.randomizeChromosome(random, length));
    }
    private static Stream<Arguments> randomizeChromosomeArgumentsProvider() {
        return Stream.of(
                Arguments.of(new Chromosome(List.of(Gene.ONE, Gene.ZERO, Gene.ZERO, Gene.ZERO, Gene.ZERO)), 5, 1),
                Arguments.of(new Chromosome(List.of(Gene.ONE, Gene.ZERO, Gene.ONE, Gene.ZERO, Gene.ZERO)), 5, 2),
                Arguments.of(new Chromosome(List.of(Gene.ONE, Gene.ZERO, Gene.ZERO, Gene.ONE, Gene.ZERO)), 5, 5),
                Arguments.of(new Chromosome(List.of(Gene.ONE, Gene.ONE, Gene.ONE, Gene.ONE)), 4, 117),
                Arguments.of(new Chromosome(List.of(Gene.ONE, Gene.ZERO, Gene.ZERO, Gene.ONE, Gene.ZERO, Gene.ONE)), 6, 552157)
        );
    }

    @DisplayName("Should crossover work")
    @ParameterizedTest(name = "{index} => expected={0}, chromosome1={1}, chromosome2={2}")
    @MethodSource("crossoverArgumentsProvider")
    void crossover(Chromosome expected, Chromosome chromosome1, Chromosome chromosome2) {
        assertEquals(expected, ChromosomeUtils.crossover(chromosome1, chromosome2));
    }
    private static Stream<Arguments> crossoverArgumentsProvider() {
        return Stream.of(
                Arguments.of(
                        new Chromosome(List.of(Gene.ONE, Gene.ZERO, Gene.ZERO, Gene.ZERO, Gene.ONE, Gene.ZERO)),
                        new Chromosome(List.of(Gene.ONE, Gene.ZERO, Gene.ZERO, Gene.ONE, Gene.ONE, Gene.ONE)),
                        new Chromosome(List.of(Gene.ZERO, Gene.ZERO, Gene.ONE, Gene.ZERO, Gene.ONE, Gene.ZERO))
                ),
                Arguments.of(
                        new Chromosome(List.of(Gene.ONE, Gene.ONE)),
                        new Chromosome(List.of(Gene.ONE, Gene.ZERO)),
                        new Chromosome(List.of(Gene.ZERO, Gene.ONE))
                ),
                Arguments.of(
                        new Chromosome(List.of(Gene.ZERO, Gene.ONE, Gene.ONE, Gene.ZERO)),
                        new Chromosome(List.of(Gene.ZERO, Gene.ONE, Gene.ZERO, Gene.ZERO)),
                        new Chromosome(List.of(Gene.ONE, Gene.ONE, Gene.ONE, Gene.ZERO))
                ),
                Arguments.of(
                        new Chromosome(List.of(Gene.ZERO, Gene.ZERO, Gene.ONE, Gene.ONE, Gene.ZERO)),
                        new Chromosome(List.of(Gene.ZERO, Gene.ZERO, Gene.ZERO, Gene.ZERO, Gene.ZERO)),
                        new Chromosome(List.of(Gene.ONE, Gene.ONE, Gene.ONE, Gene.ONE, Gene.ZERO))
                ),
                Arguments.of(
                        new Chromosome(List.of(Gene.ZERO, Gene.ONE, Gene.ONE)),
                        new Chromosome(List.of(Gene.ZERO, Gene.ZERO, Gene.ZERO)),
                        new Chromosome(List.of(Gene.ONE, Gene.ONE, Gene.ONE))
                ),
                Arguments.of(
                        new Chromosome(List.of(
                                Gene.ONE, Gene.ONE, Gene.ZERO, Gene.ONE, Gene.ZERO, Gene.ONE, Gene.ONE,
                                Gene.ONE, Gene.ZERO, Gene.ONE, Gene.ONE, Gene.ZERO, Gene.ZERO, Gene.ONE
                        )),
                        new Chromosome(List.of(
                                Gene.ONE, Gene.ONE, Gene.ZERO, Gene.ONE, Gene.ZERO, Gene.ONE, Gene.ONE,
                                Gene.ZERO, Gene.ZERO, Gene.ONE, Gene.ONE, Gene.ONE, Gene.ZERO, Gene.ZERO
                        )),
                        new Chromosome(List.of(
                                Gene.ZERO, Gene.ONE, Gene.ONE, Gene.ZERO, Gene.ONE, Gene.ZERO, Gene.ONE,
                                Gene.ONE, Gene.ZERO, Gene.ONE, Gene.ONE, Gene.ZERO, Gene.ZERO, Gene.ONE
                        ))
                ),
                Arguments.of(
                        new Chromosome(List.of(
                                Gene.ONE, Gene.ONE, Gene.ZERO, Gene.ZERO, Gene.ONE, Gene.ZERO, Gene.ONE, Gene.ONE,
                                Gene.ONE, Gene.ONE, Gene.ZERO, Gene.ONE, Gene.ZERO, Gene.ONE, Gene.ZERO
                        )),
                        new Chromosome(List.of(
                                Gene.ONE, Gene.ONE, Gene.ZERO, Gene.ZERO, Gene.ONE, Gene.ZERO, Gene.ONE, Gene.ZERO,
                                Gene.ZERO, Gene.ZERO, Gene.ONE, Gene.ONE, Gene.ZERO, Gene.ONE, Gene.ZERO
                        )),
                        new Chromosome(List.of(
                                Gene.ZERO, Gene.ZERO, Gene.ONE, Gene.ONE, Gene.ZERO, Gene.ONE, Gene.ZERO, Gene.ONE,
                                Gene.ONE, Gene.ONE, Gene.ZERO, Gene.ONE, Gene.ZERO, Gene.ONE, Gene.ZERO
                        ))
                ),
                Arguments.of(
                        new Chromosome(List.of(Gene.ONE, Gene.ZERO, Gene.ONE, Gene.ZERO, Gene.ZERO, Gene.ONE)),
                        new Chromosome(List.of(Gene.ONE, Gene.ZERO, Gene.ONE, Gene.ZERO, Gene.ZERO, Gene.ONE)),
                        new Chromosome(List.of(Gene.ZERO, Gene.ONE, Gene.ONE, Gene.ZERO, Gene.ZERO, Gene.ONE))
                ),
                Arguments.of(
                        new Chromosome(List.of(Gene.ONE, Gene.ONE, Gene.ZERO, Gene.ONE, Gene.ZERO, Gene.ZERO, Gene.ONE)),
                        new Chromosome(List.of(Gene.ONE, Gene.ONE, Gene.ZERO, Gene.ZERO, Gene.ONE, Gene.ONE, Gene.ZERO)),
                        new Chromosome(List.of(Gene.ZERO, Gene.ONE, Gene.ZERO, Gene.ONE, Gene.ZERO, Gene.ZERO, Gene.ONE))
                ),
                Arguments.of(
                        new Chromosome(List.of(Gene.ONE, Gene.ZERO, Gene.ZERO, Gene.ONE, Gene.ONE)),
                        new Chromosome(List.of(Gene.ONE, Gene.ZERO, Gene.ONE, Gene.ZERO)),
                        new Chromosome(List.of(Gene.ZERO, Gene.ONE, Gene.ZERO, Gene.ZERO, Gene.ONE, Gene.ONE))
                ),
                Arguments.of(
                        new Chromosome(List.of(Gene.ZERO, Gene.ONE, Gene.ONE)),
                        new Chromosome(List.of(Gene.ZERO, Gene.ZERO)),
                        new Chromosome(List.of(Gene.ONE, Gene.ONE, Gene.ONE))
                ),
                Arguments.of(
                        new Chromosome(List.of(
                                Gene.ONE, Gene.ZERO, Gene.ZERO, Gene.ONE, Gene.ONE, Gene.ZERO)
                        ),
                        new Chromosome(List.of(
                                Gene.ONE, Gene.ZERO, Gene.ONE, Gene.ONE)
                        ),
                        new Chromosome(List.of(
                                Gene.ONE, Gene.ONE, Gene.ZERO, Gene.ZERO, Gene.ZERO, Gene.ONE, Gene.ONE, Gene.ZERO)
                        )
                )

        );
    }

    @DisplayName("Should mutate work")
    @ParameterizedTest(name = "{index} => expected={0}, chromosome={1}, seed={2}")
    @MethodSource("mutateArgumentsProvider")
    void mutate(Chromosome expected, Chromosome chromosome, int seed) {
        Random random = new Random(seed);
        assertEquals(expected, ChromosomeUtils.mutate(chromosome, random));
    }
    private static Stream<Arguments> mutateArgumentsProvider() {
        return Stream.of(
                Arguments.of( // 1
                        new Chromosome(List.of(Gene.ZERO, Gene.ZERO, Gene.ZERO, Gene.ZERO, Gene.ZERO, Gene.ZERO)),
                        new Chromosome(List.of(Gene.ZERO, Gene.ZERO, Gene.ZERO, Gene.ONE, Gene.ZERO, Gene.ZERO)),
                        1
                ),
                Arguments.of( // 2
                        new Chromosome(List.of(Gene.ONE, Gene.ONE, Gene.ZERO, Gene.ZERO, Gene.ONE, Gene.ONE, Gene.ZERO)),
                        new Chromosome(List.of(Gene.ONE, Gene.ONE, Gene.ZERO, Gene.ZERO, Gene.ONE, Gene.ZERO, Gene.ZERO)),
                        2
                ),
                Arguments.of( // 3
                        new Chromosome(List.of(Gene.ZERO, Gene.ONE, Gene.ONE, Gene.ZERO)),
                        new Chromosome(List.of(Gene.ZERO, Gene.ONE, Gene.ZERO, Gene.ZERO)),
                        2
                ),
                Arguments.of( // 4
                        new Chromosome(List.of(
                                Gene.ONE, Gene.ZERO, Gene.ZERO, Gene.ONE, Gene.ONE, Gene.ONE, Gene.ZERO, Gene.ZERO,
                                Gene.ZERO, Gene.ONE, Gene.ONE, Gene.ONE, Gene.ZERO, Gene.ZERO, Gene.ONE
                        )),
                        new Chromosome(List.of(
                                Gene.ONE, Gene.ZERO, Gene.ZERO, Gene.ONE, Gene.ONE, Gene.ONE, Gene.ZERO, Gene.ZERO,
                                Gene.ZERO, Gene.ONE, Gene.ONE, Gene.ONE, Gene.ZERO, Gene.ONE, Gene.ONE
                        )),
                        2
                ),
                Arguments.of( // 5
                        new Chromosome(List.of(
                                Gene.ONE, Gene.ZERO, Gene.ZERO, Gene.ONE, Gene.ONE, Gene.ONE, Gene.ZERO, Gene.ZERO,
                                Gene.ZERO, Gene.ONE, Gene.ONE, Gene.ONE, Gene.ZERO, Gene.ZERO, Gene.ONE
                        )),
                        new Chromosome(List.of(
                                Gene.ONE, Gene.ZERO, Gene.ZERO, Gene.ONE, Gene.ONE, Gene.ONE, Gene.ZERO, Gene.ZERO,
                                Gene.ZERO, Gene.ONE, Gene.ONE, Gene.ONE, Gene.ZERO, Gene.ZERO, Gene.ZERO
                        )),
                        3
                ),
                Arguments.of( // 6
                        new Chromosome(List.of(
                                Gene.ONE, Gene.ZERO, Gene.ZERO, Gene.ZERO, Gene.ONE, Gene.ONE, Gene.ZERO, Gene.ZERO,
                                Gene.ZERO, Gene.ONE, Gene.ONE, Gene.ONE, Gene.ZERO, Gene.ZERO, Gene.ONE
                        )),
                        new Chromosome(List.of(
                                Gene.ONE, Gene.ZERO, Gene.ZERO, Gene.ONE, Gene.ONE, Gene.ONE, Gene.ZERO, Gene.ZERO,
                                Gene.ZERO, Gene.ONE, Gene.ONE, Gene.ONE, Gene.ZERO, Gene.ZERO, Gene.ONE
                        )),
                        11
                ),
                Arguments.of( // 7
                        new Chromosome(List.of(
                                Gene.ONE, Gene.ZERO, Gene.ZERO, Gene.ZERO, Gene.ONE, Gene.ONE, Gene.ZERO, Gene.ZERO,
                                Gene.ZERO, Gene.ONE, Gene.ONE, Gene.ONE, Gene.ZERO, Gene.ZERO, Gene.ONE
                        )),
                        new Chromosome(List.of(
                                Gene.ZERO, Gene.ZERO, Gene.ZERO, Gene.ZERO, Gene.ONE, Gene.ONE, Gene.ZERO, Gene.ZERO,
                                Gene.ZERO, Gene.ONE, Gene.ONE, Gene.ONE, Gene.ZERO, Gene.ZERO, Gene.ONE
                        )),
                        118
                )

        );
    }

}
