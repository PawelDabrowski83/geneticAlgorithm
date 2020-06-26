package org.example;

public final class Gene {
    protected static final Gene ONE = new Gene(true);
    protected static final Gene ZERO = new Gene(false);

    private final boolean value;

    private Gene(boolean value) {
        this.value = value;
    }

    public boolean isValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gene)) return false;

        Gene gene = (Gene) o;

        return isValue() == gene.isValue();
    }

    @Override
    public int hashCode() {
        return (isValue() ? 1 : 0);
    }

    @Override
    public String toString() {
        return "Gene{" +
                "value=" + value +
                '}';
    }
}
