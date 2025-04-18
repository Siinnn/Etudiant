import java.util.Scanner;

public class Main {
 public static void main(String[] args) {
  // Test rapide de la classe Etudiant
  testRapideEtudiant();

  // Lancement du menu principal
  demarrerGestionEtudiants();
 }

 public static void demarrerGestionEtudiants() {
  Scanner scanner = new Scanner(System.in);
  GestionEtudiant gestion = new GestionEtudiant();

  // Initialiser la liste si nécessaire
  if (!gestion.isListeInitialisee()) {
   gestion.initialiserListeEtudiants(scanner);
  }

  // Affichage du menu
  boolean quitter = false;
  while (!quitter) {
   afficherMenu();
   int choix = scanner.nextInt();
   scanner.nextLine(); // Pour consommer le retour à la ligne

   switch (choix) {
    case 1:
     gestion.afficherParOrdreDeMetite();
     break;
    case 2:
     gestion.afficherPremierEtudiant();
     break;
    case 3:
     gestion.afficherDernierEtudiant();
     break;
    case 4:
     gestion.reinitialiserListe();
     System.out.print("Voulez-vous saisir une nouvelle liste d'étudiants? (o/n): ");
     String reponse = scanner.nextLine().trim().toLowerCase();
     if (reponse.equals("o") || reponse.equals("oui")) {
      gestion.initialiserListeEtudiants(scanner);
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

  scanner.close();
 }

 private static void afficherMenu() {
  System.out.println("\n===== MENU =====");
  System.out.println("1. Afficher les étudiants par ordre de mérite");
  System.out.println("2. Afficher les informations sur le premier étudiant");
  System.out.println("3. Afficher les informations du dernier étudiant");
  System.out.println("4. Réinitialiser la liste de la classe");
  System.out.println("5. Quitter le programme");
  System.out.print("Votre choix : ");
 }

 public static void testRapideEtudiant() {
  System.out.println("=== TEST RAPIDE DE LA CLASSE ETUDIANT ===\n");

  double[] notes1 = { 18.0, 16.0, 17.0, 15.0 };
  double[] notes2 = { 10.0, 12.0, 9.0, 11.0 };

  Etudiant etudiant1 = new Etudiant("E001", "Dupont Jean", 20010115, notes1);
  Etudiant etudiant2 = new Etudiant("E002", "Martin Sophie", 20020220, notes2);

  System.out.println("--- Étudiant 1 ---");
  etudiant1.afficher();

  System.out.println("\n--- Étudiant 2 ---");
  etudiant2.afficher();

  System.out.println("\n--- Comparaison des moyennes ---");
  double moyenne1 = etudiant1.calculerMoyenne();
  double moyenne2 = etudiant2.calculerMoyenne();

  System.out.println("Moyenne de " + etudiant1.getNom() + ": " + moyenne1);
  System.out.println("Moyenne de " + etudiant2.getNom() + ": " + moyenne2);

  if (moyenne1 > moyenne2) {
   System.out.println(etudiant1.getNom() + " a la meilleure moyenne.");
  } else if (moyenne2 > moyenne1) {
   System.out.println(etudiant2.getNom() + " a la meilleure moyenne.");
  } else {
   System.out.println("Les deux étudiants ont la même moyenne.");
  }

  // Demander à l'utilisateur s'il veut continuer vers l'interface principale
  Scanner scanner = new Scanner(System.in);
  System.out.println("\nVoulez-vous continuer vers l'interface de gestion des étudiants ? (o/n): ");
  String reponse = scanner.nextLine().trim().toLowerCase();

  if (!reponse.equals("o") && !reponse.equals("oui")) {
   System.out.println("Fin du programme. Au revoir !");
   System.exit(0);
  }
 }
}