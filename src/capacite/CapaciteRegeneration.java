package capacite;

import canard.Canard;

public class CapaciteRegeneration extends CapaciteSpeciale {
    private final static int PV_REGENERATED = 20;

    @Override
    public void activer(Canard canard, Canard cible) {
        canard.regenerer(PV_REGENERATED);
    }
}
