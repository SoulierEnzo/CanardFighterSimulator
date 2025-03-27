public abstract class Canard {
    private final String nom;
    private int pointsDeVie;
    private int pointsAttaque;
    TypeCanard type;

    public Canard(String nom, int pointsDeVie, int pointsAttaque, TypeCanard type) {
        this.nom = nom;
        this.pointsDeVie = pointsDeVie;
        this.pointsAttaque = pointsAttaque;
        this.type = type;
    }

    public void subirDegats(int degats) {
        pointsAttaque -= degats;
    }

    public void attaquer(Canard autreCanard) {
        autreCanard.subirDegats(
                (int) (pointsAttaque * TypeCanard.getMultiplicateur(this.type, autreCanard.getType()))
        );
    }

    public abstract void utiliserCapaciteSpeciale();

    public boolean estKO() {
        return pointsDeVie <= 0;
    }

    public String getNom() {
        return nom;
    }

    public int getPointsDeVie() {
        return pointsDeVie;
    }

    public int getPointsAttaque() {
        return pointsAttaque;
    }

    public TypeCanard getType() {
        return type;
    }
}
