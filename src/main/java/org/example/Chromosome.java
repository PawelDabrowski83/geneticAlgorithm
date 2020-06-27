package org.example;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Chromosome {

    List<Gene> genes;

    public Chromosome(List<Gene> genes) {
        this.genes = genes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chromosome)) return false;

        Chromosome that = (Chromosome) o;

        return Objects.equals(genes, that.genes);
    }

    @Override
    public int hashCode() {
        return genes != null ? genes.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Chromosome{" +
                "genes=" + genes +
                '}';
    }

    public long getNumber() {
        if (genes == null || Collections.emptyList().equals(genes)) {
            return 0;
        }
        List<Gene> temp = new java.util.ArrayList<>(List.copyOf(genes));
        Collections.reverse(temp);
        int counter = 0;
        long sum = 0;
        while (counter < temp.size()) {
            if (Gene.ONE.equals(temp.get(counter))) {
                sum += Math.pow(2.0, (double) counter);
            }
            counter++;
        }
        return sum;
    }
}
