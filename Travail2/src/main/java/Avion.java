import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Avion")
public class Avion {
    @Id
    @Column(name = "matricule")
    private int matricule;
    
    @ManyToOne
    @JoinColumn(name = "Type_nom", nullable = false)
    private Type type;
    
    @OneToMany(mappedBy = "avion")
    private Set<Reparation> reparations;
    
    @OneToMany(mappedBy = "avion")
    private Set<AvionTest> tests;
    
    @ManyToMany(mappedBy = "avionsPilotes")
    private Set<Pilote> pilotes;

    // Getters et Setters
    public int getMatricule() { return matricule; }
    public void setMatricule(int matricule) { this.matricule = matricule; }
    
    public Type getType() { return type; }
    public void setType(Type type) { this.type = type; }
    
    public Set<Reparation> getReparations() { return reparations; }
    public void setReparations(Set<Reparation> reparations) { this.reparations = reparations; }
    
    public Set<AvionTest> getTests() { return tests; }
    public void setTests(Set<AvionTest> tests) { this.tests = tests; }
    
    public Set<Pilote> getPilotes() { return pilotes; }
    public void setPilotes(Set<Pilote> pilotes) { this.pilotes = pilotes; }
}
