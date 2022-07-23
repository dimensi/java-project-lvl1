package hexlet.code;

public final class Calc {
    public static final int PLUS_OPERATION = 1;
    public static final int MINUS_OPERATION = 2;
    public static final int MULTIPLY_OPERATION = 3;
    public static final int[] OPERATIONS = {PLUS_OPERATION, MINUS_OPERATION, MULTIPLY_OPERATION};
    private int answer;
    private String question;

    public Calc(int a, int b, int type) {
        switch (type) {
            case PLUS_OPERATION -> {
                answer = a + b;
                question = formatQuestion(a, b, "+");
            }
            case MINUS_OPERATION -> {
                answer = a - b;
                question = formatQuestion(a, b, "-");
            }
            case MULTIPLY_OPERATION -> {
                answer = a * b;
                question = formatQuestion(a, b, "*");
            }
            default -> {
                answer = 0;
                question = "unknown operation";
            }
        }
    }

    private String formatQuestion(int first, int second, String operation) {
        return String.format("%s %s %s", first, operation, second);
    }

    public int getAnswer() {
        return answer;
    }

    public String getQuestion() {
        return question;
    }
}
