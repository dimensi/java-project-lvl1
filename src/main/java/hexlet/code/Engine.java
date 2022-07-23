package hexlet.code;

import hexlet.code.games.Game;

import java.util.Random;
import java.util.Scanner;

public final class Engine {
    public static final int MAX_ANSWERS = 3;
    private final Scanner scanner = new Scanner(System.in);
    private String playerName;

    public Scanner getScanner() {
        return scanner;
    }

    public void welcomePlayer() {
        System.out.println("Welcome to the Brain Games!");
    }

    public void goodbyeSuccessPlayer() {
        System.out.printf("Congratulations, %s!%n", playerName);
    }

    public void goodbyeFailPlayer() {
        System.out.printf("Let's try again, %s!%n", playerName);
    }

    public void askName() {
        System.out.println("May I have your name?");
        this.playerName = scanner.nextLine().trim();
        System.out.printf("Hello, %s!%n", playerName);
    }
    public boolean startAskQuestions(Game game) {
        for (var i = 0; i < MAX_ANSWERS; i++) {
            var result = game.askQuestion();
            if (!result) {
                return false;
            }
        }
        return true;
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
