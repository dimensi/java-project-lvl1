package hexlet.code;

import hexlet.code.games.Game;
import hexlet.code.games.GreetGame;
import hexlet.code.games.EvenGame;

import java.util.Scanner;

public class App {

    public static final Game[] GAMES = {
        new GreetGame(),
        new EvenGame(),
    };
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("Goodbye!")));
        System.out.println("Please enter the game number and press Enter.");
        int answer = gameMenu();

        if (answer != 0 && answer <= GAMES.length) {
            var game = GAMES[answer - 1];
            game.start();
        } else {
            System.out.println("Goodbye!");
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
