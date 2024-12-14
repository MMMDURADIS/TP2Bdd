//Ludovic Hébert et Enrik Bernier
package com.projet.Entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Avion")
public class Avion {
    @Id
    @Column(name = "matricule")
    private int matricule;
    
    @ManyToOne
    @JoinColumn(name = "Type_nom", nullable = true)
    private Type type;
    
    @OneToMany(mappedBy = "avion")
    private Set<Reparation> reparations = new HashSet<Reparation>();
    
    @OneToMany(mappedBy = "avion")
    private Set<AvionTest> tests = new HashSet<AvionTest>();
    
    @ManyToMany(mappedBy = "avionsPilotes")
    private Set<Pilote> pilotes = new HashSet<Pilote>();

    // Getters et Setters
    public int getMatricule() { return matricule; }
    public void setMatricule(int matricule) { this.matricule = matricule; }
    
    public Type getType() { return type; }
    public void setType(Type type) { this.type = type; }
    
    public Set<Reparation> getReparations() { return reparations; }
    public void setReparations(Set<Reparation> reparations) { this.reparations = reparations; }
    
    public Set<AvionTest> getTests() { return tests; }
    public void setTests(Set<AvionTest> tests) { this.tests = tests; }
    
    public Set<Pilote> getPilotes() { return pilotes; }
    public void setPilotes(Set<Pilote> pilotes) { this.pilotes = pilotes; }
}
