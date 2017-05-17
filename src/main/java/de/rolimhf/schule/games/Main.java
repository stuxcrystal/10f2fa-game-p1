package de.rolimhf.schule.games;

import java.util.Scanner;

/**
 * This is the main class of the game program.
 *
 * It will initialize its state and initiate the game.
 */
public class Main {

    /**
     * Since we don't want to always create a new scanner instance,
     * we are just gonna cache it here.
     */
    private static Scanner scanner;

    /**
     * Returns a single line with a prompt.
     * @param prompt The prompt.
     * @return The line the user entered.
     */
    static String getLine(String prompt) {
        if (scanner == null) scanner = new Scanner(System.in);
        if (prompt != null) System.out.print(prompt);
        return scanner.nextLine();
    }

    /**
     * Queries the user for a hand.
     *
     * If the player mistypes, it will retry until the player chooses
     * a valid hand.
     *
     * @return The hand the player chose.
     */
    static Hand getHandFromPlayer() {
        while (true) {
            String yourChoice = getLine("Your Choice: ");
            try {
                return Hand.valueOf(yourChoice.toUpperCase());
            } catch (IllegalArgumentException ignored) {
                System.out.println("This is not a valid hand. Try again.");
            }
        }
    }

    /**
     * The actual game.
     * @param argv
     */
    public static void main(String[] argv) {

        System.out.println("Welcome to Rock Paper Scissors Deluxe 2");

        Hand yourHand = getHandFromPlayer();
        Hand myHand = Hand.getRandomHand();

        System.out.println(String.format("%s against %s", yourHand, myHand));

        if (yourHand.isSlaying(myHand)) {
            System.out.println("You win");
        } else if (myHand.isSlaying(yourHand)) {
            System.out.println("I win");
        } else {
            System.out.println("It's a draw");
        }
    }

}
