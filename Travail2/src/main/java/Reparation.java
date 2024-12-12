import jakarta.persistence.*;
import java.util.Date;

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
    
    @Column(name = "CoutTotal", nullable = false, precision = 6, scale = 2)
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
