package statut;

public final class StatutBrulure extends Statut {
    private int degats;

    public StatutBrulure(int duree, int degats) {
        super("Brulure", duree);
        this.degats = degats;
    }

    public int getDegats() {
        return degats;
    }
}
