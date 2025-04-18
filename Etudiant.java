class Etudiant {
    private String matricule;
    private String nom;
    private int dateDeNaissance;
    private double[] notes;

    public Etudiant(String matricule, String nom, int dateDeNaissance, double[] notes) {
        this.matricule = matricule;
        this.nom = nom;
        this.dateDeNaissance = dateDeNaissance;
        this.notes = notes;
    }

    public void afficher() {
        System.out.println("Matricule: " + matricule);
        System.out.println("Nom: " + nom);
        System.out.println("Date de naissance: " + dateDeNaissance);
        for (int i = 0; i < notes.length; i++) {
            System.out.println("Note " + (i + 1) + ": " + notes[i]);
        }
        System.out.println("Moyenne: " + calculerMoyenne());
    }

    public double calculerMoyenne() {
        double somme = 0;
        for (double note : notes) {
            somme += note;
        }
        return somme / notes.length;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getNom() {
        return nom;
    }

    public double[] getNotes() {
        return notes;
    }
}