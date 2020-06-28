package org.example;

import java.util.Random;

public class GeneUtils {
    public static Gene randomizeGene(Random random) {
        return random.nextInt(2) == 1 ? Gene.ONE : Gene.ZERO;
    }

}
