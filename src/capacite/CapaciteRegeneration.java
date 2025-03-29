package capacite;

import canard.Canard;

public class CapaciteRegeneration extends CapaciteSpeciale {
    private final static int PV_REGENERATED = 20;

    public CapaciteRegeneration() {
        super("Regeneration");
    }

    @Override
    public void activer(Canard canard, Canard cible) {
        canard.regenerer(PV_REGENERATED);
    }
}
