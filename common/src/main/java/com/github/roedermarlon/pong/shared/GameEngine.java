package com.github.roedermarlon.pong.shared;

import lombok.Getter;

@Getter
/**
 * Represents the game engine.
 */
public abstract class GameEngine {

    private final int PADDLE_WIDTH = 10, PADDLE_HEIGHT = 100;
    private final int BALL_SIZE = 20;
    private final int paddle1Y = 250, paddle2Y = 250;
    private int ballX = 390, ballY = 290;
    private int ballXDir = -1, ballYDir = -1;

    /**
     * Moves the paddle 1 up.
     */
    public void nextStep() {
        ballX += ballXDir;
        ballY += ballYDir;

        if (ballY <= 0 || ballY >= getHeight() - BALL_SIZE) {
            ballYDir = -ballYDir;
        }

        if (ballX <= 40 && ballY >= paddle1Y && ballY <= paddle1Y + PADDLE_HEIGHT) {
            ballXDir = -ballXDir;
        }

        if (ballX >= getWidth() - 60 && ballY >= paddle2Y && ballY <= paddle2Y + PADDLE_HEIGHT) {
            ballXDir = -ballXDir;
        }

        if (ballX < 0 || ballX > getWidth()) {
            ballX = 390;
            ballY = 290;
            ballXDir = -1;
            ballYDir = -1;
        }

        // TODO: update
        // TODO: eventually remove
    }

    /**
     * Returns the height of the game field.
     *
     * @return the height of the game field.
     */
    public abstract int getHeight();

    /**
     * Returns the width of the game field.
     *
     * @return the width of the game field.
     */
    public abstract int getWidth();
}
