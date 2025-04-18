public class Main {
 public static void main(String[] args) {
  int[] notes = { 15, 12, 18, 10, 14 };

  Etudiant etudiant = new Etudiant("Dupont Jean", "123 Avenue des Étudiants, Paris", 20010115, notes);
  Etudiant etudiant1 = new Etudiant("Durand Marie", "456 Rue des Étudiants, Lyon", 20020220, notes);
  Etudiant etudiant2 = new Etudiant("Martin Pierre", "789 Boulevard des Étudiants, Marseille", 20030325, notes);
  Etudiant etudiant3 = new Etudiant("Dubois Lucie", "101 Rue des Étudiants, Nantes", 20040430, notes);
  Etudiant etudiant4 = new Etudiant("Girard Nicolas", "123 Rue des Étudiants, Paris", 20050531, notes);

  Etudiant[] etudiants = { etudiant, etudiant1, etudiant2, etudiant3, etudiant4 };

  for (int i = 0; i < etudiants.length; i++) {
   System.out.println("\n--- Étudiant " + (i + 1) + " ---");
   etudiants[i].afficher();
   System.out.println("Moyenne des notes : " + etudiants[i].calculerMoyenne());
   System.out.println("--------------------");
  }
 }
}