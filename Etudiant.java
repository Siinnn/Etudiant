import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Etudiant {
    private String nom;
    private LocalDate dateNaissance;
    private Map<Matiere, Double> notes;
    private double moyenne;

    public Etudiant(String nom, LocalDate dateNaissance) {
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.notes = new HashMap<>();
        this.moyenne = 0.0;
    }

    public void ajouterNote(Matiere matiere, double note) {
        notes.put(matiere, note);
        calculerMoyenne();
    }

    private void calculerMoyenne() {
        double sommeNotes = 0.0;
        double sommeCoefficients = 0.0;

        for (Map.Entry<Matiere, Double> entry : notes.entrySet()) {
            Matiere matiere = entry.getKey();
            double note = entry.getValue();
            sommeNotes += note * matiere.getCoefficient();
            sommeCoefficients += matiere.getCoefficient();
        }

        if (sommeCoefficients > 0) {
            moyenne = sommeNotes / sommeCoefficients;
        }
    }

    public String getNom() {
        return nom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public double getMoyenne() {
        return moyenne;
    }

    public Map<Matiere, Double> getNotes() {
        return notes;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "nom='" + nom + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", moyenne=" + moyenne +
                '}';
    }
}
}