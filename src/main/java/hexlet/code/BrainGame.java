package hexlet.code;

import java.util.Scanner;

public final class BrainGame implements Game {
    public void start() {
        System.out.println("Welcome to the Brain Games!");

        String name = askName();
        System.out.printf("Hello, %s!%n", name);
    }

    private String askName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("May I have your name?");
        String name = sc.nextLine();
        sc.close();
        return name;
    }

}
