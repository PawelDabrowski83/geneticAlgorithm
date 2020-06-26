package org.example;

import java.util.List;
import java.util.Objects;

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
}
