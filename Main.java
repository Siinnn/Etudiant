import java.util.Scanner;

public class Main {
 public static void main(String[] args) {
  testRapideEtudiant();

  Scanner scanner = new Scanner(System.in);
  System.out.println("\nVoulez-vous lancer l'interface interactive de GestionEtudiant ? (o/n): ");
  String reponse = scanner.nextLine().trim().toLowerCase();

  if (reponse.equals("o") || reponse.equals("oui")) {
   System.out.println("\nLancement de l'interface interactive...");
   GestionEtudiant gestion = new GestionEtudiant();
   gestion.demarrer();
  } else {
   System.out.println("\nFin du programme. Au revoir !");
  }

  scanner.close();
 }

 public static void testRapideEtudiant() {
  System.out.println("=== TEST RAPIDE DE LA CLASSE ETUDIANT ===\n");

  double[] notes1 = { 18.0, 16.0, 17.0, 15.0 };
  double[] notes2 = { 10.0, 12.0, 9.0, 11.0 };

  Etudiant etudiant1 = new Etudiant("E001", "Dupont Jean", 20010115, notes1);
  Etudiant etudiant2 = new Etudiant("E002", "Martin Sophie", 20020220, notes2);

  // Affichage des informations des étudiants
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
 }
}