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

    public void demarrer() {
        Scanner scanner = new Scanner(System.in);

        if (!listeInitialisee) {
            initialiserListeEtudiants(scanner);
        }

        // Affichage du menu
        boolean quitter = false;
        while (!quitter) {
            afficherMenu();
            int choix = scanner.nextInt();
            scanner.nextLine(); // Pour consommer le retour à la ligne

            switch (choix) {
                case 1:
                    afficherParOrdreDeMetite();
                    break;
                case 2:
                    afficherPremierEtudiant();
                    break;
                case 3:
                    afficherDernierEtudiant();
                    break;
                case 4:
                    reinitialiserListe();
                    System.out.println("La liste a été réinitialisée.");
                    System.out.print("Voulez-vous saisir une nouvelle liste d'étudiants? (o/n): ");
                    String reponse = scanner.nextLine().trim().toLowerCase();
                    if (reponse.equals("o") || reponse.equals("oui")) {
                        initialiserListeEtudiants(scanner);
                    }
                    break;
                case 5:
                    quitter = true;
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }

        // Ne pas fermer le scanner pour éviter les problèmes avec System.in
    }

    private void initialiserListeEtudiants(Scanner scanner) {
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

    private void afficherMenu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1. Afficher les étudiants par ordre de mérite");
        System.out.println("2. Afficher les informations sur le premier étudiant");
        System.out.println("3. Afficher les informations du dernier étudiant");
        System.out.println("4. Réinitialiser la liste de la classe");
        System.out.println("5. Quitter le programme");
        System.out.print("Votre choix : ");
    }

    private void afficherParOrdreDeMetite() {
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

    private void afficherPremierEtudiant() {
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

    private void afficherDernierEtudiant() {
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

    private void reinitialiserListe() {
        etudiants = null;
        listeInitialisee = false;
    }

    public static void main(String[] args) {
        GestionEtudiant gestion = new GestionEtudiant();
        gestion.demarrer();
    }
}