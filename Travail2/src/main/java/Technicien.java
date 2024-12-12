import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Technicien")
@PrimaryKeyJoinColumn(name = "matricule")
public class Technicien extends Employe {
    @ManyToMany
    @JoinTable(
        name = "Specialisation",
        joinColumns = @JoinColumn(name = "Technicien_matricule"),
        inverseJoinColumns = @JoinColumn(name = "Type_nom")
    )
    private Set<Type> specialisations;
    
    @OneToMany(mappedBy = "technicien")
    private Set<Reparation> reparations;

    // Getters et Setters
    public Set<Type> getSpecialisations() { return specialisations; }
    public void setSpecialisations(Set<Type> specialisations) { this.specialisations = specialisations; }
    
    public Set<Reparation> getReparations() { return reparations; }
    public void setReparations(Set<Reparation> reparations) { this.reparations = reparations; }
}
