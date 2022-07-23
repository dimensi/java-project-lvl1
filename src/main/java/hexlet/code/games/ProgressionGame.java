package hexlet.code.games;

import hexlet.code.Engine;

public final class ProgressionGame implements Game {
    private final Engine gameEngine = new Engine();

    public static final int RANDOM_MAX_INT = 100;
    public static final int RANDOM_MIN_INT = 1;
    public static final int RANDOM_DELTA_MIN = 2;
    public static final int RANDOM_DELTA_MAX = 12;
    public static final int RANDOM_PROGRESSION_SIZE_MIN = 5;
    public static final int RANDOM_PROGRESSION_SIZE_MAX = 10;

    public String getGameName() {
        return "Progression";
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

    private int[] generateProgression() {
        var start = gameEngine.getRandomNumber(RANDOM_MIN_INT, RANDOM_MAX_INT);
        var delta = gameEngine.getRandomNumber(RANDOM_DELTA_MIN, RANDOM_DELTA_MAX);
        var size = gameEngine.getRandomNumber(RANDOM_PROGRESSION_SIZE_MIN, RANDOM_PROGRESSION_SIZE_MAX);
        int[] progression = new int[size];
        for (var i = 0; i < size; i++) {
            progression[i] = start + delta * i;
        }
        return progression;
    }

    private String generateQuestion(int[] progression, int omitIdx) {
        var questionBuilder = new StringBuilder();
        var idx = 0;
        for (var num : progression) {
            if (idx == omitIdx) {
                questionBuilder.append(".. ");
            } else {
                questionBuilder.append(String.format("%s ", num));
            }
            idx++;
        }
        return questionBuilder.toString().trim();
    }
    public boolean askQuestion() {
        var progression = generateProgression();
        var idx = gameEngine.getRandomNumber(RANDOM_MIN_INT, progression.length - 1);
        var rightAnswer = progression[1] - progression[0];
        gameEngine.sayQuestion(generateQuestion(progression, idx));
        var answer = gameEngine.getScanner().nextInt();
        gameEngine.sayYourAnswer(answer);
        if (answer == rightAnswer) {
            gameEngine.sayCorrect();
            return true;
        }

        gameEngine.sayWrong(answer, rightAnswer);
        return false;
    }
}
