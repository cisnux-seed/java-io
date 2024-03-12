package dev.cisnux.javaio;

import java.util.Scanner;

public class InputApp {
    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Hi " + name + '!');
    }
}
