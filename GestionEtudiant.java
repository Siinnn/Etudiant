import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class GestionEtudiant {
    private List<String> matieres;
    private Etudiant[] etudiants;
    private int effectif;
    private boolean listeInitialisee = false;

    public GestionEtudiant() {
        this.matieres = new ArrayList<>();
        initialiserMatieres();
    }

    private void initialiserMatieres() {
        matieres.add("Mathématiques");
        matieres.add("Physique");
        matieres.add("Informatique");
        matieres.add("Anglais");
    }

    // Méthode pour initialiser la liste des étudiants
    public void initialiserListeEtudiants(Scanner scanner) {
        System.out.print("Entrez l'effectif de la classe : ");
        effectif = scanner.nextInt();
        scanner.nextLine(); // Pour consommer le retour à la ligne

        etudiants = new Etudiant[effectif];

        // Enregistrement des étudiants
        for (int i = 0; i < effectif; i++) {
            System.out.println("\nÉtudiant " + (i + 1));
            System.out.print("Matricule : ");
            String matricule = scanner.nextLine();

            System.out.print("Nom : ");
            String nom = scanner.nextLine();

            System.out.print("Date de naissance (AAAAMMJJ) : ");
            int dateNaissance = scanner.nextInt();
            scanner.nextLine(); // Pour consommer le retour à la ligne

            // Création du tableau de notes
            double[] notes = new double[matieres.size()];
            for (int j = 0; j < matieres.size(); j++) {
                System.out.print("Note en " + matieres.get(j) + " : ");
                notes[j] = scanner.nextDouble();
                scanner.nextLine(); // Pour consommer le retour à la ligne
            }

            etudiants[i] = new Etudiant(matricule, nom, dateNaissance, notes);
        }

        listeInitialisee = true;
        System.out.println("\nListe d'étudiants initialisée avec succès!");
    }

    // Méthode pour afficher les étudiants par ordre de mérite
    public void afficherParOrdreDeMetite() {
        if (!listeInitialisee || etudiants == null || etudiants.length == 0) {
            System.out.println("Aucun étudiant enregistré.");
            return;
        }

        // Créer une liste temporaire pour le tri
        List<Etudiant> etudiantsTries = new ArrayList<>();
        for (Etudiant e : etudiants) {
            if (e != null) {
                etudiantsTries.add(e);
            }
        }

        // Trier par moyenne décroissante
        Collections.sort(etudiantsTries, new Comparator<Etudiant>() {
            @Override
            public int compare(Etudiant e1, Etudiant e2) {
                return Double.compare(e2.calculerMoyenne(), e1.calculerMoyenne());
            }
        });

        // Afficher les étudiants triés
        System.out.println("\n=== ÉTUDIANTS PAR ORDRE DE MÉRITE ===");
        for (int i = 0; i < etudiantsTries.size(); i++) {
            System.out.println("\nRang " + (i + 1) + " :");
            etudiantsTries.get(i).afficher();
        }
    }

    // Méthode pour afficher le premier étudiant
    public void afficherPremierEtudiant() {
        if (!listeInitialisee || etudiants == null || etudiants.length == 0) {
            System.out.println("Aucun étudiant enregistré.");
            return;
        }

        // Trouver l'étudiant avec la meilleure moyenne
        Etudiant meilleur = etudiants[0];
        for (int i = 1; i < etudiants.length; i++) {
            if (etudiants[i] != null && etudiants[i].calculerMoyenne() > meilleur.calculerMoyenne()) {
                meilleur = etudiants[i];
            }
        }

        System.out.println("\n=== PREMIER ÉTUDIANT ===");
        meilleur.afficher();
    }

    // Méthode pour afficher le dernier étudiant
    public void afficherDernierEtudiant() {
        if (!listeInitialisee || etudiants == null || etudiants.length == 0) {
            System.out.println("Aucun étudiant enregistré.");
            return;
        }

        // Trouver l'étudiant avec la moins bonne moyenne
        Etudiant dernier = etudiants[0];
        for (int i = 1; i < etudiants.length; i++) {
            if (etudiants[i] != null && etudiants[i].calculerMoyenne() < dernier.calculerMoyenne()) {
                dernier = etudiants[i];
            }
        }

        System.out.println("\n=== DERNIER ÉTUDIANT ===");
        dernier.afficher();
    }

    // Méthode pour réinitialiser la liste
    public void reinitialiserListe() {
        etudiants = null;
        listeInitialisee = false;
        System.out.println("La liste a été réinitialisée.");
    }

    // Vérifier si la liste est initialisée
    public boolean isListeInitialisee() {
        return listeInitialisee;
    }
}