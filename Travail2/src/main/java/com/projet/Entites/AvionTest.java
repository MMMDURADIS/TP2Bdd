package com.projet.Entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.IdClass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "AvionTest")
@IdClass(AvionTestId.class)
public class AvionTest {
    @Id
    @ManyToOne
    @JoinColumn(name = "Avion_matricule")
    private Avion avion;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "Test_numero")
    private Test test;
    
    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    // Getters et Setters
    public Avion getAvion() { return avion; }
    public void setAvion(Avion avion) { this.avion = avion; }
    
    public Test getTest() { return test; }
    public void setTest(Test test) { this.test = test; }
    
    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
}
