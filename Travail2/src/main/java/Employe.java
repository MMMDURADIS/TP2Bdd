import java.util.Date;

import jakarta.persistence.*;


@Entity
@Table(name = "Employe")
@Inheritance(strategy = InheritanceType.JOINED)
public class Employe {
    @Id
    @Column(name = "matricule")
    private int matricule;
    
    @Column(name = "nom")
    private String nom;
    
    @Column(name = "prenom")
    private String prenom;
    
    @ManyToOne
    @JoinColumn(name = "adresse", nullable = false)
    private Adresse adresse;
    
    @Column(name = "tel")
    private String tel;
    
    @Column(name = "dateEngagement", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateEngagement;
    
    @Column(name = "Salaire", precision = 6, scale = 2)
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

