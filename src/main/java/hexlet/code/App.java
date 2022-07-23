package hexlet.code;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        int answer = gameMenu();

        switch (answer) {
            case 1 -> new BrainGame().start();
            case 2 -> new EvenGame().start();
            default -> System.out.println("Goodbye!");
        }
        System.exit(0);
    }
    public static int gameMenu() {
        System.out.println("1 - Greet\n2 - Even\n0 - Exit");
        var sc = new Scanner(System.in);
        return sc.nextInt();
    }
}
