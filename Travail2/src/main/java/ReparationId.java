import java.io.Serializable;
import java.util.Objects;

//Classe pour la clé composée de Reparation
public class ReparationId implements Serializable {
 private int avion;
 private int technicien;

 public ReparationId() {}

 public ReparationId(int avion, int technicien) {
     this.avion = avion;
     this.technicien = technicien;
 }

 // equals() et hashCode()
 @Override
 public boolean equals(Object o) {
     if (this == o) return true;
     if (o == null || getClass() != o.getClass()) return false;
     ReparationId that = (ReparationId) o;
     return avion == that.avion && technicien == that.technicien;
 }

 @Override
 public int hashCode() {
     return Objects.hash(avion, technicien);
 }
}
