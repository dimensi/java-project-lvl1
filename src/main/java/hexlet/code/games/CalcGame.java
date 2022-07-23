package hexlet.code.games;

import hexlet.code.Calc;
import hexlet.code.Engine;
import hexlet.code.Game;

import static hexlet.code.Calc.OPERATIONS;

public final class CalcGame implements Game {
    private final Engine gameEngine = new Engine();

    public static final int RANDOM_MAX_INT = 20;
    public static final int RANDOM_MIN_INT = 0;


//    private int operationStartIdx = ThreadLocalRandom.current().nextInt(0, OPERATIONS.length);

    public String getGameName() {
        return "Calc";
    }

    public void start() {
        gameEngine.welcomePlayer();
        gameEngine.askName();

        System.out.println("What is the result of the expression?");

        var isSuccess = gameEngine.startAskQuestions(this);
        if (isSuccess) {
            gameEngine.goodbyeSuccessPlayer();
        } else {
            gameEngine.goodbyeFailPlayer();
        }
    }



    public boolean askQuestion() {
        var firstOperand = gameEngine.getRandomNumber(RANDOM_MIN_INT, RANDOM_MAX_INT);
        var secondOperand = gameEngine.getRandomNumber(RANDOM_MIN_INT, RANDOM_MAX_INT);
        var operationIdx = gameEngine.getRandomNumber(0, OPERATIONS.length - 1);
        int operation = OPERATIONS[operationIdx];
        var calc = new Calc(firstOperand, secondOperand, operation);


        gameEngine.sayQuestion(calc.getQuestion());
        var answer = gameEngine.getScanner().nextInt();
        gameEngine.sayYourAnswer(answer);
        if (answer == calc.getAnswer()) {
            gameEngine.sayCorrect();
            return true;
        }

        gameEngine.sayWrong(answer, calc.getAnswer());
        return false;
    }
}
