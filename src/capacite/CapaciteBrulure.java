package capacite;

import canard.Canard;
import statut.StatutBrulure;

public class CapaciteBrulure extends CapaciteSpeciale {
    private final static int TIME = 1;
    private final static double MULTIPLICATEUR_POINT_ATTAQUE = 0.5;

    public CapaciteBrulure() {
        super("Brulure");
    }

    @Override
    public void activer(Canard canard, Canard cible) {
        canard.attaquer(cible);
        cible.appliquerStatut(
                new StatutBrulure(
                        TIME,
                        (int) (MULTIPLICATEUR_POINT_ATTAQUE * canard.getPointsAttaque()),
                        cible
                )
        );
    }
}
