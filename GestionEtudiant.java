import java.util.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GestionEtudiant {
    private List<Matiere> matieres;
    private List<Etudiant> etudiants;

    public GestionEtudiant() {
        this.matieres = new ArrayList<>();
        this.etudiants = new ArrayList<>();
        initialiserMatieres();
    }

    private void initialiserMatieres() {
        matieres.add(new Matiere("Mathématiques", 4));
        matieres.add(new Matiere("Physique", 3));
        matieres.add(new Matiere("Informatique", 3));
        matieres.add(new Matiere("Anglais", 2));
    }

}