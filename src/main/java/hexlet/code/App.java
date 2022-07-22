package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        var sc = new Scanner(System.in);
        String name = sc.next();
        System.out.printf("Hello, %s!%n", name);
    }
}
