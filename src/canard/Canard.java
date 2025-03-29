package canard;

import capacite.CapaciteSpeciale;
import statut.Statut;
import statut.StatutBrulure;
import statut.StatutGel;
import statut.StatutVitesseAttaque;

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
    private List<CapaciteSpeciale> capaciteSpecialesUtilisee = new ArrayList<CapaciteSpeciale>();
    private List<Statut> statuts = new ArrayList<Statut>();

    public Canard(String nom, int pointsDeVie, int pointsAttaque, TypeCanard type) {
        this.nom = nom;
        this.pointsDeVieMax = pointsDeVie;
        this.pointsDeVie = pointsDeVie;
        this.pointsAttaque = pointsAttaque;
        this.type = type;
    }

    public void subirDegats(int degats) {
        pointsDeVie -= degats;
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

    public void utiliserCapaciteSpeciale(int capaciteSpeciale, Canard cible) {
        if (capaciteSpeciale < 1 || capaciteSpeciale > capaciteSpeciales.size()) {
            throw new IndexOutOfBoundsException("Capacite speciale innexistante");
        }
        CapaciteSpeciale capacite = capaciteSpeciales.remove(capaciteSpeciale - 1);
        capacite.activer(this, cible);
        capaciteSpecialesUtilisee.add(capacite);
    }

    public void attribuerCapaciteSpeciale(CapaciteSpeciale capaciteSpeciale) {
        capaciteSpeciales.add(capaciteSpeciale);
    }

    public int nombreCapaciteSpeciale() {
        return capaciteSpeciales.size();
    }

    public String listerCapaciteSpeciale() {
        int choix = 1;
        String out = "";
        for (CapaciteSpeciale capaciteSpeciale : capaciteSpeciales) {
            out += choix + ". " + capaciteSpeciale.getNom();
            choix++;
        }
        return out;
    }

    public void appliquerStatut(Statut statut) {
        statuts.add(statut);
    }

    public int appliquerEffetStatuts() {
        int nbAttaques = 1;
        ArrayList<Statut> statutARetirer = new ArrayList<>();
        for (Statut statut : statuts) {
            statut.appliquerEffet();
            switch (statut) {
                case StatutBrulure statutBrulure:
                    break;
                case StatutGel statutGel:
                    nbAttaques = 0;
                    break;
                case StatutVitesseAttaque statutVitesseAttaque:
                    // Si statut gel alors pas d'attaque
                    if (nbAttaques != 0) {
                        nbAttaques = statutVitesseAttaque.getNbAttaque();
                    }
                    break;
            }
            if (statut.getDuree() == 0) {
                statutARetirer.add(statut);
            }
        }
        for (Statut statut : statutARetirer) {
            statuts.remove(statut);
        }
        return nbAttaques;
    }

    public void reinitialiser() {
        this.pointsDeVie = pointsDeVieMax;
        while (!capaciteSpecialesUtilisee.isEmpty()) {
            capaciteSpeciales.add(capaciteSpecialesUtilisee.removeFirst());
        }
        statuts.clear();
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
