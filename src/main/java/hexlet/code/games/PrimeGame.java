package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Game;

public final class PrimeGame implements Game {
    private final Engine gameEngine = new Engine();

    public static final int RANDOM_MAX_INT = 500;
    public static final int RANDOM_MIN_INT = 1;

    public String getGameName() {
        return "Prime";
    }

    public void start() {
        gameEngine.welcomePlayer();
        gameEngine.askName();

        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        var isSuccess = gameEngine.startAskQuestions(this);
        if (isSuccess) {
            gameEngine.goodbyeSuccessPlayer();
        } else {
            gameEngine.goodbyeFailPlayer();
        }
    }

    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i <= num / i; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean askQuestion() {
        var number = gameEngine.getRandomNumber(RANDOM_MIN_INT, RANDOM_MAX_INT);
        var rightAnswer = isPrime(number) ? "yes" : "no";
        gameEngine.sayQuestion(number);
        var answer = gameEngine.getScanner().nextLine().trim();
        gameEngine.sayYourAnswer(answer);
        if (answer.equals(rightAnswer)) {
            gameEngine.sayCorrect();
            return true;
        }

        gameEngine.sayWrong(answer, rightAnswer);
        return false;
    }
}
