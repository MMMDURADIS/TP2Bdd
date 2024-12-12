import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Pilote")
@PrimaryKeyJoinColumn(name = "matricule")
public class Pilote extends Employe {
    @ManyToMany
    @JoinTable(
        name = "Qualification",
        joinColumns = @JoinColumn(name = "Pilote_matricule"),
        inverseJoinColumns = @JoinColumn(name = "Type_nom")
    )
    private Set<Type> qualifications;
    
    @ManyToMany
    @JoinTable(
        name = "Piloter",
        joinColumns = @JoinColumn(name = "Pilote_matricule"),
        inverseJoinColumns = @JoinColumn(name = "Avion_matricule")
    )
    private Set<Avion> avionsPilotes;
    
    @OneToMany(mappedBy = "pilote")
    private Set<Examination> examinations;

    // Getters et Setters
    public Set<Type> getQualifications() { return qualifications; }
    public void setQualifications(Set<Type> qualifications) { this.qualifications = qualifications; }
    
    public Set<Avion> getAvionsPilotes() { return avionsPilotes; }
    public void setAvionsPilotes(Set<Avion> avionsPilotes) { this.avionsPilotes = avionsPilotes; }
    
    public Set<Examination> getExaminations() { return examinations; }
    public void setExaminations(Set<Examination> examinations) { this.examinations = examinations; }
}
