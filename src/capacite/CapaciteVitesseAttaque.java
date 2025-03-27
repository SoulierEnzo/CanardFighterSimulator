package capacite;

import canard.Canard;
import statut.StatutVitesseAttaque;

public class CapaciteVitesseAttaque extends CapaciteSpeciale {
    private final static int TIME = 2;

    @Override
    public void activer(Canard canard, Canard cible) {
        canard.appliquerStatut(
                new StatutVitesseAttaque(TIME)
        );
    }
}
