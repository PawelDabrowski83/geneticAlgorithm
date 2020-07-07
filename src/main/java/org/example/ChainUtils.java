package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChainUtils {

    protected final static Random random = new Random();

    public static Chain randomizeChain(int size) {
        List<Chromosome> chromosomes = new ArrayList<>();
        int counter = size;
        while (counter > 0) {
            chromosomes.add(ChromosomeUtils.randomizeChromosome(random, random.nextInt(1000)));
            counter--;
        }
        return new Chain(chromosomes);
    }
}
