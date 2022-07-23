package hexlet.code;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public final class EvenGame implements Game {

    private final Scanner sc = new Scanner(System.in);

    public static final int RANDOM_MAX_INT = 100;
    public static final int RANDOM_MIN_INT = 1;
    public static final int COUNT_ANSWERS = 3;

    public void start() {
        System.out.println("Welcome to the Brain Games!");

        String name = askName();

        System.out.printf("Hello, %s!%n", name);

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        for (var i = 0; i < COUNT_ANSWERS; i++) {
            if (askNumber()) {
                System.out.println("Correct!");
            } else {
                System.out.printf("Let's try again, %s!%n", name);
                sc.close();
                return;
            }
        }
        System.out.printf("Congratulations, %s!%n", name);
        sc.close();
    }

    private String askName() {
        System.out.println("May I have your name?");
        return sc.nextLine().trim();
    }

    private boolean askNumber() {
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
