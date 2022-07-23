package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Game;

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
        var randomNum = gameEngine.getRandomNumber(RANDOM_MIN_INT, RANDOM_MAX_INT);
        var isEven = randomNum % 2 == 0;
        var rightAnswer = isEven ? "yes" : "no";

        gameEngine.sayQuestion(randomNum);
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
