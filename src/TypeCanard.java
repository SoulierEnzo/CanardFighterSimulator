public enum TypeCanard {
    EAU,
    FEU,
    GLACE,
    VENT;


    public static double getMultiplicateur(TypeCanard attaquant, TypeCanard cible) {
        if (
            (attaquant == EAU   && cible == FEU) ||
            (attaquant == FEU   && cible == GLACE) ||
            (attaquant == GLACE && cible == VENT) ||
            (attaquant == VENT  && cible == EAU)
        ) {
            return 1.5;
        }

        if (
            (attaquant == FEU   && cible == EAU) ||
            (attaquant == GLACE && cible == FEU) ||
            (attaquant == VENT  && cible == GLACE) ||
            (attaquant == EAU   && cible == VENT)
        ) {
            return 0.5;
        }

        return 1.0;
    }
}


