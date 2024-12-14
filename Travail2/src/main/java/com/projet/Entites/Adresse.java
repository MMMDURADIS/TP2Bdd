//Ludovic Hébert et Enrik Bernier
package com.projet.Entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

import com.projet.Util.CodePostal;

@Entity
@Indexed
@Table(name = "Adresse")
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "numeroRue", nullable = false)
    private int numeroRue;
    
    @Column(name = "nomRue", nullable = true)
    private String nomRue;
    
    @Column(name = "ville", nullable = false)
    private String ville;
    
    @Column(name = "codePostal", length = 45, nullable = false)
    @CodePostal
    @FullTextField
    private String codePostal;
    
    @Column(name = "province", nullable = false)
    private String province;
    
    @Column(name = "pays", nullable = false)
    private String pays;

    @OneToMany(mappedBy = "adresse")
    private Set<Employe> employees = new HashSet<Employe>();

    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public int getNumeroRue() { return numeroRue; }
    public void setNumeroRue(int numeroRue) { this.numeroRue = numeroRue; }
    
    public String getNomRue() { return nomRue; }
    public void setNomRue(String nomRue) { this.nomRue = nomRue; }
    
    public String getVille() { return ville; }
    public void setVille(String ville) { this.ville = ville; }
    
    public String getCodePostal() { return codePostal; }
    public void setCodePostal(String codePostal) { this.codePostal = codePostal.toUpperCase(); }
    
    public String getProvince() { return province; }
    public void setProvince(String province) { this.province = province; }
    
    public String getPays() { return pays; }
    public void setPays(String pays) { this.pays = pays; }
}
