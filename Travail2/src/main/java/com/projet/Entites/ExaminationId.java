//Ludovic Hébert et Enrik Bernier
package com.projet.Entites;

import java.io.Serializable;
import java.util.Objects;

public class ExaminationId implements Serializable {
    private int pilote;
    private int examen;

    public ExaminationId() {}

    public ExaminationId(int pilote, int examen) {
        this.pilote = pilote;
        this.examen = examen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExaminationId that = (ExaminationId) o;
        return pilote == that.pilote && examen == that.examen;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pilote, examen);
    }
}
