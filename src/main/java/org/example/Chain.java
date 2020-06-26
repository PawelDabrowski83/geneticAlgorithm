package org.example;

import java.util.List;

public class Chain {

    List<Chromosome> chromosomes;

    public Chain(List<Chromosome> chromosomes) {
        this.chromosomes = chromosomes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chain)) return false;

        Chain chain = (Chain) o;

        return chromosomes != null ? chromosomes.equals(chain.chromosomes) : chain.chromosomes == null;
    }

    @Override
    public int hashCode() {
        return chromosomes != null ? chromosomes.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Chain{" +
                "chromosomes=" + chromosomes +
                '}';
    }
}
