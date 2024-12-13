//Ludovic Hébert et Enrik Bernier
package com.projet.Entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinTable;
import java.util.Set;

@Entity
@Table(name = "Technicien")
@PrimaryKeyJoinColumn(name = "matricule")
public class Technicien extends Employe {
    @ManyToMany
    @JoinTable(
        name = "Specialisation",
        joinColumns = @JoinColumn(name = "Technicien_matricule"),
        inverseJoinColumns = @JoinColumn(name = "Type_nom")
    )
    private Set<Type> specialisations;
    
    @OneToMany(mappedBy = "technicien")
    private Set<Reparation> reparations;

    // Getters et Setters
    public Set<Type> getSpecialisations() { return specialisations; }
    public void setSpecialisations(Set<Type> specialisations) { this.specialisations = specialisations; }
    
    public Set<Reparation> getReparations() { return reparations; }
    public void setReparations(Set<Reparation> reparations) { this.reparations = reparations; }
}
