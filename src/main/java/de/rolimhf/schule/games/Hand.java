package de.rolimhf.schule.games;

import java.util.Random;

/**
 * This class contains every possible result
 */
public enum Hand {
    ROCK,
    PAPER,
    SCISSORS,
    LIZARD,
    SPOCK;

    // We need to set up the rules of the game beforehand.
    //
    // Since forward declarations are not supported, we are
    // initializing its state in this block.
    static {
        ROCK.setSlays(SCISSORS, LIZARD);
        PAPER.setSlays(SPOCK, ROCK);
        SCISSORS.setSlays(LIZARD, PAPER);
        LIZARD.setSlays(PAPER, SCISSORS);
        SPOCK.setSlays(SCISSORS, ROCK);
    }

    /**
     * Store an instance of an RNG here.
     */
    private static Random random = new Random();

    /**
     * Stores which hands should be slain.
     */
    private Hand[] slays;

    /**
     * This function sets which hands this hand slays.
     *
     * To prevent illegal forward references, we are defering
     * to our own static block.
     *
     * @param hands The hands this hand slays.
     */
    private void setSlays(Hand... hands) {
        this.slays = hands;
    }

    /**
     * This method checks whether the hand is slaying the other hand.
     *
     * @param hand The hand
     * @return {@code true} if the hand slays the other hand. {@code false} if not.
     */
    public boolean isSlaying(Hand hand) {
        // Since we didn't learn sets yet we're just gonna
        // iterate over our array.
        for (Hand slays : this.slays) {
            if (hand == slays) return true;
        }
        return false;
    }

    /**
     * Returns a random hand. This is the hand the computer will choose.
     * @return The random hand the computer will play against the player.
     */
    public static Hand getRandomHand() {
        int ordinal = random.nextInt(Hand.values().length);
        return Hand.values()[ordinal];
    }
}
