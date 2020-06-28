package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChromosomeUtils {

    public static Chromosome randomizeChromosome(Random random, int length) {
        List<Gene> genes = new ArrayList<>();
        int counter = 0;
        while (counter < length) {
            genes.add(GeneUtils.randomizeGene(random));
            counter++;
        }
        return new Chromosome(genes);
    }
}
