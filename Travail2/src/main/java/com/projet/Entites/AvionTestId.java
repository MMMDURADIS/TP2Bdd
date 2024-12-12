package com.projet.Entites;

import java.io.Serializable;
import java.util.Objects;

public class AvionTestId implements Serializable {
    private int avion;
    private int test;

    public AvionTestId() {}

    public AvionTestId(int avion, int test) {
        this.avion = avion;
        this.test = test;
    }

    // equals() et hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AvionTestId that = (AvionTestId) o;
        return avion == that.avion && test == that.test;
    }

    @Override
    public int hashCode() {
        return Objects.hash(avion, test);
    }
}
