package hexlet.code;

import hexlet.code.games.CalcGame;
import hexlet.code.games.GcdGame;
import hexlet.code.games.GreetGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.PrimeGame;
import hexlet.code.games.ProgressionGame;

import java.util.Scanner;

public class App {

    public static final Game[] GAMES = {
        new GreetGame(),
        new EvenGame(),
        new CalcGame(),
        new GcdGame(),
        new ProgressionGame(),
        new PrimeGame(),
    };
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("Goodbye!")));
        System.out.println("Please enter the game number and press Enter.");
        int answer = gameMenu();

        if (answer != 0 && answer <= GAMES.length) {
            var game = GAMES[answer - 1];
            game.start();
        }
        System.exit(0);
    }
    public static int gameMenu() {
        StringBuilder menuBuilder = new StringBuilder();
        int idx = 1;
        for (var game : GAMES) {
            menuBuilder.append(String.format("%s - %s\n", idx++, game.getGameName()));
        }
        menuBuilder.append("0 - Exit");
        System.out.println(menuBuilder);
        var sc = new Scanner(System.in);
        return sc.nextInt();
    }
}
