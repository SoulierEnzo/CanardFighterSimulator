package canard;

import capacite.CapaciteSpeciale;
import statut.Statut;

import java.util.ArrayList;
import java.util.List;

public abstract class Canard {
    public final static int MIN_POINTS_DE_VIE = 20;
    public final static int MAX_POINTS_DE_VIE = 300;
    public final static int MIN_POINTS_ATTAQUE = 10;
    public final static int MAX_POINTS_ATTAQUE = 200;

    private final String nom;
    private int pointsDeVieMax;
    private int pointsDeVie;
    private int pointsAttaque;
    private TypeCanard type;
    private List<CapaciteSpeciale> capaciteSpeciales = new ArrayList<CapaciteSpeciale>();
    private List<Statut> statuts = new ArrayList<Statut>();

    public Canard(String nom, int pointsDeVie, int pointsAttaque, TypeCanard type) {
        this.nom = nom;
        this.pointsDeVieMax = pointsDeVie;
        this.pointsDeVie = pointsDeVie;
        this.pointsAttaque = pointsAttaque;
        this.type = type;
    }

    public void subirDegats(int degats) {
        pointsAttaque -= degats;
    }

    public void regenerer(int pointDeVie) {
        pointsDeVie += pointDeVie;
        if (pointsDeVie > pointsDeVieMax) {
            pointsDeVie = pointsDeVieMax;
        }
    }

    public void attaquer(Canard autreCanard) {
        autreCanard.subirDegats(
                (int) (pointsAttaque * TypeCanard.getMultiplicateur(this.type, autreCanard.getType()))
        );
    }

    public void utiliserCapaciteSpeciale(int capaciteSpeciale) {
        utiliserCapaciteSpeciale(capaciteSpeciale, null);
    }

    public void utiliserCapaciteSpeciale(int capaciteSpeciale, Canard cible) {
        if (capaciteSpeciale < 0 || capaciteSpeciale >= capaciteSpeciales.size()) {
            throw new IndexOutOfBoundsException("Capacite speciale innexistante");
        }
        capaciteSpeciales.get(capaciteSpeciale).activer(this, cible);
    }

    public void attribuerCapaciteSpeciale(CapaciteSpeciale capaciteSpeciale) {
        capaciteSpeciales.add(capaciteSpeciale);
    }

    public void appliquerStatut(Statut statut) {
        statuts.add(statut);
    }

    public boolean estKO() {
        return pointsDeVie <= 0;
    }

    public String getNom() {
        return nom;
    }

    public int getPointsDeVie() {
        return pointsDeVie;
    }

    public int getPointsAttaque() {
        return pointsAttaque;
    }

    public TypeCanard getType() {
        return type;
    }

    @Override
    public String toString() {
        String out = nom + "\n    TYPE : " + type.toString()
            + ":\n    PV : " + pointsDeVie + "\n    PA : " + pointsAttaque;
        return out;
    }
}
