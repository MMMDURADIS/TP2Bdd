//Ludovic Hébert et Enrik Bernier
package com.projet.Entites;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
@Table(name = "Employe")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Employe {
    @Id
    @Column(name = "matricule")
    private int matricule;
    
    @Column(name = "nom", length = 45, nullable = true)
    private String nom;
    
    @Column(name = "prenom", length = 45, nullable = true)
    private String prenom;
    
    @ManyToOne
    @JoinColumn(name = "adresse", nullable = true)
    private Adresse adresse;
    
    @Column(name = "tel", length = 45, nullable = true)
    private String tel;
    
    @Column(name = "dateEngagement", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateEngagement;
    
    @Column(name = "Salaire", precision = 8, nullable = true)
    private double salaire;

    // Getters et Setters
    public int getMatricule() { return matricule; }
    public void setMatricule(int matricule) { this.matricule = matricule; }
    
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    
    public Adresse getAdresse() { return adresse; }
    public void setAdresse(Adresse adresse) { this.adresse = adresse; }
    
    public String getTel() { return tel; }
    public void setTel(String tel) { this.tel = tel; }
    
    public Date getDateEngagement() { return dateEngagement; }
    public void setDateEngagement(Date dateEngagement) { this.dateEngagement = dateEngagement; }
    
    public double getSalaire() { return salaire; }
    public void setSalaire(double salaire) { this.salaire = salaire; }
}

