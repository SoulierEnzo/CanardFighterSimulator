package canard;

import capacite.CapaciteGel;

public class CanardGlace extends Canard {
    public CanardGlace(String nom, int pointsDeVie, int pointsAttaque) {
        super(nom, pointsDeVie, pointsAttaque, TypeCanard.GLACE);
        attribuerCapaciteSpeciale(new CapaciteGel());
    }
}
