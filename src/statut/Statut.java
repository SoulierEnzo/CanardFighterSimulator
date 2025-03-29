package statut;

import canard.Canard;

public sealed abstract class Statut permits StatutBrulure, StatutGel, StatutVitesseAttaque {
    private String nom;
    private int duree;
    protected Canard canard;

    public Statut(String nom, int duree, Canard canard) {
        this.nom = nom;
        this.duree = duree;
        this.canard = canard;
    }

    public String getNom() {
        return nom;
    }

    public int getDuree() {
        return duree;
    }

    public void appliquerEffet() {
        duree--;
    }
}
