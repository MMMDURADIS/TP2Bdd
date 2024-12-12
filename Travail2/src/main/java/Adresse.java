import jakarta.persistence.*;

@Entity
@Table(name = "Adresse")
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "numeroRue", nullable = false)
    private int numeroRue;
    
    @Column(name = "nomRue")
    private String nomRue;
    
    @Column(name = "ville", nullable = false)
    private String ville;
    
    @Column(name = "codePostal", nullable = false)
    private String codePostal;
    
    @Column(name = "province", nullable = false)
    private String province;
    
    @Column(name = "pays", nullable = false)
    private String pays;

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
    public void setCodePostal(String codePostal) { this.codePostal = codePostal; }
    
    public String getProvince() { return province; }
    public void setProvince(String province) { this.province = province; }
    
    public String getPays() { return pays; }
    public void setPays(String pays) { this.pays = pays; }
}
