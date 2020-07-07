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

    public static Chromosome crossover(Chromosome chromosome1, Chromosome chromosome2) {
        List<Gene> firstHalf = chromosome1.genes.subList(0, chromosome1.genes.size() / 2);
        List<Gene> secondHalf = chromosome2.genes.subList(chromosome2.genes.size() / 2, chromosome2.genes.size());
        List<Gene> temp = new ArrayList<>(firstHalf);
        temp.addAll(secondHalf);
        return new Chromosome(temp);
    }
}
