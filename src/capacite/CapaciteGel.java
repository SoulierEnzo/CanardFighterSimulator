package capacite;

import canard.Canard;
import statut.StatutGel;

public class CapaciteGel extends CapaciteSpeciale {
    private final static int TIME = 1;

    @Override
    public void activer(Canard canard, Canard cible) {
        cible.appliquerStatut(
                new StatutGel(TIME)
        );
    }
}
