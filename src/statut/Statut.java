package statut;

public sealed class Statut permits StatutBrulure, StatutGel, StatutVitesseAttaque {
    private String nom;
    private int duree;

    public Statut(String nom, int duree) {
        this.nom = nom;
        this.duree = duree;
    }

    public String getNom() {
        return nom;
    }

    public int getDuree() {
        return duree;
    }
}
