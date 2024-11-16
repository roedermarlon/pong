package de.marlonr.game.shared;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
/**
 * Represents the scoreboard of the game.
 */
public class Scoreboard {

    /**
     * The score of player 1 and 2.
     */
    int score1, score2;
}
