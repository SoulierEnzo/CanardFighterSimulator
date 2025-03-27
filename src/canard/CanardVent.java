package canard;

import capacite.CapaciteVitesseAttaque;

public class CanardVent extends Canard {
    public CanardVent(String nom, int pointsDeVie, int pointsAttaque) {
        super(nom, pointsDeVie, pointsAttaque, TypeCanard.VENT);
        attribuerCapaciteSpeciale(new CapaciteVitesseAttaque());
    }
}
