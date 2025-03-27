import canard.Canard;
import canard.TypeCanard;

import java.util.ArrayList;
import java.util.List;
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
                    lancerBataille();
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
        System.out.println("Bienvenue dans canard.Canard Fighter Simulator !");
        System.out.println("1. Créer un canard");
        System.out.println("2. Lancer une bataille");
        System.out.println("3. Quitter");
    }

    private static void creerCanard() {
        // Choix du type
        System.out.println("Choisir le type de canard :");
        int choix = 1;
        for (TypeCanard type : TypeCanard.values()) {
            System.out.println(choix + ". " + type.toString());
            choix++;
        }
        choix = faireUnChoix(1, TypeCanard.values().length);
        TypeCanard type = TypeCanard.values()[choix - 1];

        // Choix du nom
        System.out.println("Choisir le nom du canard :");
        String nom = scanner.nextLine();

        // Choix des points de vie
        System.out.println("Choisir le nombre de points de vie :");
        choix = faireUnChoix(Canard.MIN_POINTS_DE_VIE, Canard.MAX_POINTS_DE_VIE);
        int pointsDeVie = choix;

        // Choix des points d'attaque
        System.out.println("Choisir le nombre de points d'attaque :");
        choix = faireUnChoix(Canard.MIN_POINTS_ATTAQUE, Canard.MAX_POINTS_ATTAQUE);
        int pointAttaque = choix;

        // Création du canard
        canards.add(type.creerCanard(nom, pointsDeVie, pointAttaque));
    }

    private static void lancerBataille() {
        int choix = 1;
        for (Canard canard : canards) {
            System.out.println(choix + ". " + canard);
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