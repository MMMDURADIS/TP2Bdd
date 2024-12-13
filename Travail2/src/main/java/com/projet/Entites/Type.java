//Ludovic Hébert et Enrik Bernier
package com.projet.Entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import java.util.Set;

@Entity
@Table(name = "Type")
public class Type {
    @Id
    @Column(name = "nom")
    private String nom;
    
    @Column(name = "capacite")
    private int capacite;
    
    @Column(name = "poids", precision = 8)
    private double poids;
    
    @Column(name = "rayonAction", precision = 8)
    private double rayonAction;

    @ManyToMany(mappedBy = "specialisations")
    private Set<Technicien> techniciens;

    @ManyToMany(mappedBy = "qualifications")
    private Set<Pilote> pilotes;

    // Getters et Setters
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    
    public int getCapacite() { return capacite; }
    public void setCapacite(int capacite) { this.capacite = capacite; }
    
    public double getPoids() { return poids; }
    public void setPoids(double poids) { this.poids = poids; }
    
    public double getRayonAction() { return rayonAction; }
    public void setRayonAction(double rayonAction) { this.rayonAction = rayonAction; }
}