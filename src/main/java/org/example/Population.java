package org.example;

import java.util.List;

public class Population {

    List<Solvable> pool;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Population)) return false;

        Population that = (Population) o;

        return pool != null ? pool.equals(that.pool) : that.pool == null;
    }

    @Override
    public int hashCode() {
        return pool != null ? pool.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Population{" +
                "pool=" + pool +
                '}';
    }
}
