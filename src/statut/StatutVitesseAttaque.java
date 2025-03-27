package statut;

public final class StatutVitesseAttaque extends Statut {
    private int nbAttaque = 2;

    public StatutVitesseAttaque(int duree) {
        super("Augmentation vitesse d'attaque", duree);
    }

    public int getNbAttaque() {
        return nbAttaque;
    }
}
