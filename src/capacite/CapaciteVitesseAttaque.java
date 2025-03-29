package capacite;

import canard.Canard;
import statut.StatutVitesseAttaque;

public class CapaciteVitesseAttaque extends CapaciteSpeciale {
    private final static int TIME = 2;

    public CapaciteVitesseAttaque() {
        super("Augmentation vitesse d'attaque");
    }

    @Override
    public void activer(Canard canard, Canard cible) {
        canard.appliquerStatut(
                new StatutVitesseAttaque(TIME, canard)
        );
    }
}
