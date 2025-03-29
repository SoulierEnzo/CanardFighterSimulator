package statut;

import canard.Canard;

public final class StatutBrulure extends Statut {
    private int degats;

    public StatutBrulure(int duree, int degats, Canard canard) {
        super("Brulure", duree, canard);
        this.degats = degats;
    }

    public int getDegats() {
        return degats;
    }

    @Override
    public void appliquerEffet() {
        this.canard.subirDegats(degats);
        super.appliquerEffet();
    }
}
