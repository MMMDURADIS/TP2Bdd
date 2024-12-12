import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Examen")
public class Examen {
    @Id
    @Column(name = "identifiant")
    private int identifiant;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "Examencol", columnDefinition = "TEXT")
    private String examencol;
    
    @OneToMany(mappedBy = "examen")
    private Set<Examination> examinations;

    // Getters et Setters
    public int getIdentifiant() { return identifiant; }
    public void setIdentifiant(int identifiant) { this.identifiant = identifiant; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public String getExamencol() { return examencol; }
    public void setExamencol(String examencol) { this.examencol = examencol; }
    
    public Set<Examination> getExaminations() { return examinations; }
    public void setExaminations(Set<Examination> examinations) { this.examinations = examinations; }
}
