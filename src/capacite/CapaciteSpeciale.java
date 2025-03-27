package capacite;

import canard.Canard;

public abstract class CapaciteSpeciale {
    public void activer(Canard canard) {
        activer(canard, null);
    }

    public abstract void activer(Canard canard, Canard cible);
}
