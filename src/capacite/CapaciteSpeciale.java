package capacite;

import canard.Canard;

public abstract class CapaciteSpeciale {
    private final String nom;

    public CapaciteSpeciale(String nom) {
        this.nom = nom;
    }

    public void utiliser(Canard canard) {
        utiliser(canard, null);
    }

    public void utiliser(Canard attaquant, Canard cible) {
        activer(attaquant, cible);
    }

    public abstract void activer(Canard canard, Canard cible);

    public String getNom() {
        return nom;
    }
}
