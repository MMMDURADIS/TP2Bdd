//Ludovic Hébert et Enrik Bernier
package com.projet.Entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import java.util.Set;

@Entity
@Table(name = "Test")
public class Test {
    @Id
    @Column(name = "numero")
    private int numero;
    
    @Column(name = "nom", nullable = false)
    private String nom;
    
    @Column(name = "seuil", nullable = false, precision = 3)
    private double seuil;
    
    @OneToMany(mappedBy = "test")
    private Set<AvionTest> avionTests;

    // Getters et Setters
    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }
    
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    
    public double getSeuil() { return seuil; }
    public void setSeuil(double seuil) { this.seuil = seuil; }
    
    public Set<AvionTest> getAvionTests() { return avionTests; }
    public void setAvionTests(Set<AvionTest> avionTests) { this.avionTests = avionTests; }
}
