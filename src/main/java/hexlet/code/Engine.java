package hexlet.code;

import hexlet.code.games.Game;

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

    public void sayCorrect() {
        System.out.println("Correct!");
    }

    public void sayWrong(String answer, String rightAnswer) {
        System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%n", answer, rightAnswer);
    }
    public void sayWrong(int answer, int rightAnswer) {
        sayWrong(String.valueOf(answer), String.valueOf(rightAnswer));
    }

    public void sayYourAnswer(String answer) {
        System.out.printf("Your answer: %s%n", answer);
    }
    public void sayYourAnswer(int answer) {
        sayYourAnswer(String.valueOf(answer));
    }

    public void sayQuestion(String question) {
        System.out.printf("Question: %s%n", question);
    }
    public void sayQuestion(int question) {
        sayQuestion(String.valueOf(question));
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
