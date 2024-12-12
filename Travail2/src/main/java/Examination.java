import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Examination")
@IdClass(ExaminationId.class)
public class Examination {
    @Id
    @ManyToOne
    @JoinColumn(name = "Pilote_matricule")
    private Pilote pilote;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "Examen_identifiant")
    private Examen examen;
    
    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;
    
    @Column(name = "rapport", nullable = false, columnDefinition = "TEXT")
    private String rapport;

    // Getters et Setters
    public Pilote getPilote() { return pilote; }
    public void setPilote(Pilote pilote) { this.pilote = pilote; }
    
    public Examen getExamen() { return examen; }
    public void setExamen(Examen examen) { this.examen = examen; }
    
    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
    
    public String getRapport() { return rapport; }
    public void setRapport(String rapport) { this.rapport = rapport; }
}
