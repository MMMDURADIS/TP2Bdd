package com.projet.Entites;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.IdClass;

@Entity
@Table(name = "Reparation")
@IdClass(ReparationId.class)
public class Reparation {
    @Id
    @ManyToOne
    @JoinColumn(name = "Avion_matricule")
    private Avion avion;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "Technicien_matricule")
    private Technicien technicien;
    
    @Column(name = "CoutTotal", nullable = false, precision = 6)
    private double coutTotal;
    
    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    // Getters et Setters
    public Avion getAvion() { return avion; }
    public void setAvion(Avion avion) { this.avion = avion; }
    
    public Technicien getTechnicien() { return technicien; }
    public void setTechnicien(Technicien technicien) { this.technicien = technicien; }
    
    public double getCoutTotal() { return coutTotal; }
    public void setCoutTotal(double coutTotal) { this.coutTotal = coutTotal; }
    
    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
}
