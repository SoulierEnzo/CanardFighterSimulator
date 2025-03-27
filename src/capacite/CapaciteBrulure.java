package capacite;

import canard.Canard;
import statut.StatutBrulure;

public class CapaciteBrulure extends CapaciteSpeciale {
    private final static int TIME = 1;
    private final static double MULTIPLICATEUR_POINT_ATTAQUE = 0.1;

    @Override
    public void activer(Canard canard, Canard cible) {
        cible.appliquerStatut(
                new StatutBrulure(
                        TIME,
                        (int) (MULTIPLICATEUR_POINT_ATTAQUE * canard.getPointsAttaque())
                )
        );
    }
}
