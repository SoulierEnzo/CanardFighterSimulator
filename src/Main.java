import canard.Canard;
import canard.TypeCanard;
import capacite.CapaciteSpeciale;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    private final static String MESSAGE_ERREUR_SAISIE = "Choix invalide. Veuillez réessayer.";

    private static Scanner scanner = new Scanner(System.in);
    private static List<Canard> canards = new ArrayList<Canard>();

    public static void main(String[] args) {
        boolean quitter = false;

        while (!quitter) {
            afficherMenu();
            int choix = faireUnChoix(1, 3);
            switch (choix) {
                case 1:
                    creerCanard();
                    break;
                case 2:
                    if (canards.size() >= 2) {
                        lancerBataille();
                    } else {
                        System.out.println("Veuillez creer au moins 2 canards.");
                    }
                    break;
                case 3:
                    quitter = true;
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println(MESSAGE_ERREUR_SAISIE);
            }
        }
        scanner.close();
    }

    private static void afficherMenu() {
        System.out.println("\nBienvenue dans canard.Canard Fighter Simulator !");
        System.out.println("1. Créer un canard");
        System.out.println("2. Lancer une bataille");
        System.out.println("3. Quitter");
    }

    private static void creerCanard() {
        // Choix du type
        System.out.println("\nChoisir le type de canard :");
        int choix = 1;
        for (TypeCanard type : TypeCanard.values()) {
            System.out.println(choix + ". " + type.toString());
            choix++;
        }
        choix = faireUnChoix(1, TypeCanard.values().length);
        TypeCanard type = TypeCanard.values()[choix - 1];

        // Choix du nom
        System.out.println("\nChoisir le nom du canard :");
        String nom = scanner.nextLine();

        // Choix des points de vie
        System.out.println("\nChoisir le nombre de points de vie :");
        choix = faireUnChoix(Canard.MIN_POINTS_DE_VIE, Canard.MAX_POINTS_DE_VIE);
        int pointsDeVie = choix;

        // Choix des points d'attaque
        System.out.println("\nChoisir le nombre de points d'attaque :");
        choix = faireUnChoix(Canard.MIN_POINTS_ATTAQUE, Canard.MAX_POINTS_ATTAQUE);
        int pointAttaque = choix;

        // Création du canard
        canards.add(type.creerCanard(nom, pointsDeVie, pointAttaque));
    }

    private static void lancerBataille() {
        System.out.println("\nChoisir le canard numero 1 :");
        int choix = 1;
        for (Canard canard : canards) {
            System.out.println(choix + ". " + canard);
            choix++;
        }
        choix = faireUnChoix(1, canards.size());
        Canard canard1 = canards.get(choix - 1);

        Canard canard2 = null;
        do {
            if (canard2 != null) {
                System.out.println("Veuillez choisir un canard différent du premier !");
            }
            System.out.println("\nChoisir le canard numero 2 :");
            choix = 1;
            for (Canard canard : canards) {
                if (canard != canard1) {
                    System.out.println(choix + ". " + canard);
                }
                choix++;
            }
            choix = faireUnChoix(1, canards.size());
            canard2 = canards.get(choix - 1);
        } while(canard1 == canard2);

        duel(canard1, canard2);
        canard1.reinitialiser();
        canard2.reinitialiser();
    }

    private static void duel(Canard canard1, Canard canard2) {
        System.out.println("\nDebut du combat " + canard1.getNom() + " contre " + canard2.getNom());
        int nbTour = 1;
        while(!canard1.estKO() && !canard2.estKO()) {
            System.out.println("\nTour " + nbTour + " :");
            tourDuCanard(canard1, canard2);
            if (!canard2.estKO())
                tourDuCanard(canard2, canard1);
            nbTour++;
        }
        if (canard1.estKO()) {
            System.out.println("\nVictoire de " + canard2);
            System.out.println("Défaite de " + canard1);
        } else {
            System.out.println("\nVictoire de " + canard1);
            System.out.println("Défaite de " + canard2);
        }
    }

    private static void tourDuCanard(Canard attaquant, Canard cible) {
        System.out.println("\nAu tour de " + attaquant.getNom() + " de jouer :");
        int nbAttaques = attaquant.appliquerEffetStatuts();
        System.out.println("Votre canard :\n" + attaquant);
        System.out.println("Canard adverse :\n" + cible);
        // Si le canard a encore des capacites et s'il peut attaque, il peut choisir
        // Sinon il attaque automatiquement
        if (attaquant.nombreCapaciteSpeciale() > 0 && nbAttaques > 0) {
            System.out.println("Faites un choix :");
            System.out.println("1. Attaquer");
            System.out.println("2. Utiliser une capacite speciale");
            int choix = faireUnChoix(1, 2);
            switch (choix) {
                case 1:
                    for (int i = 0; i < nbAttaques; i++) {
                        attaquant.attaquer(cible);
                    }
                    System.out.println("Vous attaquez " + nbAttaques + " fois.");
                    break;
                case 2:
                    System.out.println("Choisissez une capacite speciale :");
                    System.out.println(attaquant.listerCapaciteSpeciale());
                    int numCapacite = faireUnChoix(1, attaquant.nombreCapaciteSpeciale());
                    attaquant.utiliserCapaciteSpeciale(numCapacite, cible);
                    break;
            }
        } else if (nbAttaques > 0) {
            for (int i = 0; i < nbAttaques; i++) {
                attaquant.attaquer(cible);
            }
            System.out.println("Vous attaquez " + nbAttaques + " fois.");
        } else {
            System.out.println("Vous ne pouvez pas attaquer.");
        }
    }

    private static int faireUnChoix(int choixMin, int choixMax) {
        int choix;
        try {
            choix = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            choix = choixMin - 1;
        }
        boolean choixOk = choix >= choixMin && choix <= choixMax;
        while (!choixOk) {
            System.out.println(MESSAGE_ERREUR_SAISIE);
            try {
                choix = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                choix = choixMin - 1;
            }
            choixOk = choix >= choixMin && choix <= choixMax;
        }
        return choix;
    }
}