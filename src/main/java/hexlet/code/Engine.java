package hexlet.code;

import java.util.Scanner;

public final class Engine {
    public static final int MAX_ANSWERS = 3;
    private final Scanner scanner = new Scanner(System.in);

    public Scanner getScanner() {
        return scanner;
    }

    public void welcomePlayer() {
        System.out.println("Welcome to the Brain Games!");
    }
    public String askName() {
        System.out.println("May I have your name?");
        var name = scanner.nextLine().trim();
        System.out.printf("Hello, %s!%n", name);
        return name;
    }
}
