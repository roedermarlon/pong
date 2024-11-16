package de.marlonr.game.shared;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@ToString
@Accessors(fluent = true)
@AllArgsConstructor
/**
 * Represents a player in the game.
 */
public abstract class GamePlayer {

    /**
     * The id of the player.
     */
    private int id;

    /**
     * The display name of the player.
     */
    private String displayName;

    /**
     * The x position of the paddle.
     */
    @Setter
    protected int paddleY, score;
}
