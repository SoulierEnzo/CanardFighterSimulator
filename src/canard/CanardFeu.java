package canard;

import capacite.CapaciteBrulure;

public class CanardFeu extends Canard {
    public CanardFeu(String nom, int pointsDeVie, int pointsAttaque) {
        super(nom, pointsDeVie, pointsAttaque, TypeCanard.FEU);
        attribuerCapaciteSpeciale(new CapaciteBrulure());
    }
}
