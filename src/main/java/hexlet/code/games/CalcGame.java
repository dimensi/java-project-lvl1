package hexlet.code.games;

import hexlet.code.Engine;

import java.util.concurrent.ThreadLocalRandom;

public final class CalcGame implements Game {
    private final Engine gameEngine = new Engine();

    public static final int RANDOM_MAX_INT = 20;
    public static final int RANDOM_MIN_INT = 0;
    public static final int PLUS_OPERATION = 1;
    public static final int MINUS_OPERATION = 2;
    public static final int MULTIPLY_OPERATION = 3;
    public static final int[] OPERATIONS = {PLUS_OPERATION, MINUS_OPERATION, MULTIPLY_OPERATION};

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

    private String formatQuestion(int first, int second, String operation) {
        return String.format("%s %s %s", first, operation, second);
    }

    public boolean askQuestion() {
        var firstOperand = ThreadLocalRandom.current().nextInt(RANDOM_MIN_INT, RANDOM_MAX_INT + 1);
        var secondOperand = ThreadLocalRandom.current().nextInt(RANDOM_MIN_INT, RANDOM_MAX_INT + 1);
        var operationIdx = ThreadLocalRandom.current().nextInt(0, OPERATIONS.length);
        int operation = OPERATIONS[operationIdx];
        int rightAnswer;
        String question;
        switch (operation) {
            case PLUS_OPERATION:
            default:
                rightAnswer = firstOperand + secondOperand;
                question = formatQuestion(firstOperand, secondOperand, "+");
                break;
            case MINUS_OPERATION:
                rightAnswer = firstOperand - secondOperand;
                question = formatQuestion(firstOperand, secondOperand, "-");
                break;
            case MULTIPLY_OPERATION:
                rightAnswer = firstOperand * secondOperand;
                question = formatQuestion(firstOperand, secondOperand, "*");
                break;
        }

        System.out.printf("Question: %s,%n", question);
        var answer = gameEngine.getScanner().nextInt();
        System.out.printf("Your answer: %s,%n", answer);
        if (answer == rightAnswer) {
            System.out.println("Correct!");
            return true;
        }

        System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%n", answer, rightAnswer);
        return false;
    }
}
