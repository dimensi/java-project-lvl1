package hexlet.code.games;

import hexlet.code.Engine;

public final class GcdGame implements Game {
    private final Engine gameEngine = new Engine();

    public static final int RANDOM_MAX_INT = 100;
    public static final int RANDOM_MIN_INT = 1;

    public String getGameName() {
        return "GCD";
    }

    public void start() {
        gameEngine.welcomePlayer();
        gameEngine.askName();

        System.out.println("Find the greatest common divisor of given numbers.");

        var isSuccess = gameEngine.startAskQuestions(this);
        if (isSuccess) {
            gameEngine.goodbyeSuccessPlayer();
        } else {
            gameEngine.goodbyeFailPlayer();
        }
    }

    private int findGCD(int num1, int num2) {
        int a = num1;
        int b = num2;

        while (true) {
            if (a == 0 || b == 0) {
                return a + b;
            }

            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }
    }
    public boolean askQuestion() {
        var a = gameEngine.getRandomNumber(RANDOM_MIN_INT, RANDOM_MAX_INT);
        var b = gameEngine.getRandomNumber(RANDOM_MIN_INT, RANDOM_MAX_INT);
        var rightAnswer = findGCD(a, b);
        System.out.printf("Question: %s %s%n", a, b);
        var answer = gameEngine.getScanner().nextInt();
        System.out.printf("Your answer: %s%n", answer);
        if (answer == rightAnswer) {
            System.out.println("Correct!");
            return true;
        }

        System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%n", answer, rightAnswer);
        return false;
    }
}
