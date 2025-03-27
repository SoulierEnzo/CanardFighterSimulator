package canard;

import capacite.CapaciteRegeneration;

public class CanardEau extends Canard {
    public CanardEau(String nom, int pointsDeVie, int pointsAttaque) {
        super(nom, pointsDeVie, pointsAttaque, TypeCanard.EAU);
        attribuerCapaciteSpeciale(new CapaciteRegeneration());
    }
}
