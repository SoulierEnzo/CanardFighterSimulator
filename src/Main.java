import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean quitter = false;

        while (!quitter) {
            afficherMenu();
            int choix;
            try {
                choix = scanner.nextInt();
            } catch (InputMismatchException e) {
                choix = 0;
            }
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
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
            scanner.close();
        }
    }

    private static void afficherMenu() {
        System.out.println("Bienvenue dans Canard Fighter Simulator !");
        System.out.println("1. Créer un canard");
        System.out.println("2. Lancer une bataille");
        System.out.println("3. Quitter");
    }

    private static void creerCanard() {

    }

    private static void lancerBataille() {

    }
}