package statut;

import canard.Canard;

public final class StatutVitesseAttaque extends Statut {
    private int nbAttaque = 1;

    public StatutVitesseAttaque(int duree, Canard canard) {
        super("Augmentation vitesse d'attaque", duree, canard);
    }

    public int getNbAttaque() {
        return nbAttaque;
    }

    @Override
    public void appliquerEffet() {
        nbAttaque++;
        super.appliquerEffet();
    }
}
