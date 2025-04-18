class Etudiant {
    private String nom;
    private String adresse;
    private int dateDeNaissance;
    private int[] notes;

    public Etudiant(String nom, String adresse, int dateDeNaissance, int[] notes) {
        this.nom = nom;
        this.adresse = adresse;
        this.dateDeNaissance = dateDeNaissance;
        this.notes = notes;
    }

    public void afficher() {
        System.out.println("Nom: " + nom);
        System.out.println("Adresse: " + adresse);
        System.out.println("Date de naissance: " + dateDeNaissance);
        for (int i = 0; i < notes.length; i++) {
            System.out.println("Note " + (i + 1) + ": " + notes[i]);
        }
    }

    public double calculerMoyenne() {
        double somme = 0;
        for (int note : notes) {
            somme += note;
        }
        return somme / notes.length;
    }

   
}