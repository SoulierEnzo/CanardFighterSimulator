package canard;

public enum TypeCanard {
    EAU,
    FEU,
    GLACE,
    VENT;

    // Ligne = attaquant | Colonne = cible
    private static final double[][] MULTIPLICATEURS = {
            //            EAU     FEU     GLACE   VENT
            /* EAU   */ { 1.0,    1.5,    1.0,    0.5 },
            /* FEU   */ { 0.5,    1.0,    1.5,    1.0 },
            /* GLACE */ { 1.0,    0.5,    1.0,    1.5 },
            /* VENT  */ { 1.5,    1.0,    0.5,    1.0 }
    };

    public static double getMultiplicateur(TypeCanard attaquant, TypeCanard cible) {
        return MULTIPLICATEURS[attaquant.ordinal()][cible.ordinal()];
    }

    public Canard creerCanard(String nom, int pointsDeVie, int pointsAttaque) {
        switch (this) {
            case EAU:
                return new CanardEau(nom, pointsDeVie, pointsAttaque);
            case FEU:
                return new CanardFeu(nom, pointsDeVie, pointsAttaque);
            case GLACE:
                return new CanardGlace(nom, pointsDeVie, pointsAttaque);
            case VENT:
                return new CanardVent(nom, pointsDeVie, pointsAttaque);
            default:
                throw new IllegalArgumentException("Type de canard non géré : " + this);
        }
    }
}


