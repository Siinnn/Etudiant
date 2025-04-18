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

    public void ajouterEtudiant(Etudiant etudiant) {
        etudiants.add(etudiant);
    }

    public void ajouterNote(Etudiant etudiant, Matiere matiere, double note) {
        etudiant.ajouterNote(matiere, note);
    }

    public List<Etudiant> getEtudiantsParMerite() {
        List<Etudiant> etudiantsTries = new ArrayList<>(etudiants);
        etudiantsTries.sort((e1, e2) -> Double.compare(e2.getMoyenne(), e1.getMoyenne()));
        return etudiantsTries;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez l'effectif de la classe : ");
        int n = scanner.nextInt();
        scanner.nextLine();

        Etudiant[] etudiants = new Etudiant[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEtudiant " + (i + 1) + " :");
            System.out.print("Nom : ");
            String nom = scanner.nextLine();
            System.out.print("Date de naissance (AAAA-MM-JJ) : ");
            LocalDate dateNaissance = LocalDate.parse(scanner.nextLine());
            System.out.print("Moyenne : ");
            double moyenne = scanner.nextDouble();
            scanner.nextLine();

            etudiants[i] = new Etudiant( nom, dateNaissance, moyenne);
        }
    }
}