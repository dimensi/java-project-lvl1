package hexlet.code.games;

import hexlet.code.Engine;

import java.util.concurrent.ThreadLocalRandom;

public final class EvenGame implements Game {

    private final Engine gameEngine = new Engine();

    public static final int RANDOM_MAX_INT = 100;
    public static final int RANDOM_MIN_INT = 1;


    public String getGameName() {
        return "Even";
    }

    public void start() {
        gameEngine.welcomePlayer();
        gameEngine.askName();

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        var isSuccess = gameEngine.startAskQuestions(this);
        if (isSuccess) {
            gameEngine.goodbyeSuccessPlayer();
        } else {
            gameEngine.goodbyeFailPlayer();
        }
    }
    public boolean askQuestion() {
        var randomNum = ThreadLocalRandom.current().nextInt(RANDOM_MIN_INT, RANDOM_MAX_INT + 1);
        var isEven = randomNum % 2 == 0;
        var rightAnswer = isEven ? "yes" : "no";

        System.out.printf("Question: %s%n", randomNum);
        var answer = gameEngine.getScanner().nextLine();
        if (answer.trim().equals(rightAnswer)) {
            System.out.println("Correct!");
            return true;
        }

        System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%n", answer, rightAnswer);
        return false;
    }
}
