package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import static hexlet.code.Engine.MAX_ANSWERS;

public final class EvenGame implements Game {

    private final Engine gameEngine = new Engine();
    private final Scanner sc = new Scanner(System.in);

    public static final int RANDOM_MAX_INT = 100;
    public static final int RANDOM_MIN_INT = 1;


    public String getGameName() {
        return "Even";
    }

    public void start() {
        gameEngine.welcomePlayer();

        String name = gameEngine.askName();

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        for (var i = 0; i < MAX_ANSWERS; i++) {
            if (askQuestion()) {
                System.out.println("Correct!");
            } else {
                System.out.printf("Let's try again, %s!%n", name);
                return;
            }
        }
        System.out.printf("Congratulations, %s!%n", name);
    }
    private boolean askQuestion() {
        var randomNum = ThreadLocalRandom.current().nextInt(RANDOM_MIN_INT, RANDOM_MAX_INT + 1);
        var isEven = randomNum % 2 == 0;
        var rightAnswer = isEven ? "yes" : "no";

        System.out.printf("Question: %s%n", randomNum);
        var answer = sc.next();
        if (answer.trim().equals(rightAnswer)) {
            return true;
        }

        System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%n", answer, rightAnswer);
        return false;
    }
}
