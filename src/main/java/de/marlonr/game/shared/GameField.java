package de.marlonr.game.shared;

/**
 * Represents the game field.
 */
public abstract class GameField {

    /**
     * Moves the paddle 1 up.
     */
    public abstract void movePaddle1Up();

    /**
     * Moves the paddle 1 down.
     *
     * @param height The height of the game field.
     */
    public abstract void movePaddle1Down(int height);

    /**
     * Moves the paddle 2 up.
     */
    public abstract void movePaddle2Up();

    /**
     * Moves the paddle 2 down.
     *
     * @param height The height of the game field.
     */
    public abstract void movePaddle2Down(int height);

    /**
     * Updates the ball position.
     *
     * @param width  The width of the game field.
     * @param height The height of the game field.
     */
    public abstract void updateBallPosition(int width, int height);

    /**
     * Returns the scoreboard.
     *
     * @return The scoreboard.
     */
    public abstract Scoreboard getScoreboard();
}