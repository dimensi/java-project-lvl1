package hexlet.code.games;

import hexlet.code.Engine;

public final class GreetGame implements Game {
    public String getGameName() {
        return "Greet";
    }

    private final Engine gameEngine = new Engine();

    public void start() {
        gameEngine.welcomePlayer();
        gameEngine.askName();
    }
}
