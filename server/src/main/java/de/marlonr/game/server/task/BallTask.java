package de.marlonr.game.server.task;

import de.marlonr.game.packet.s2c.S2CBallPositionUpdatePacket;
import de.marlonr.game.server.impl.RemoteGamePlayerImpl;

import java.util.List;

public class BallTask extends Thread {

    private final int ballSpeed;
    private final List<RemoteGamePlayerImpl> players;

    private final RemoteGamePlayerImpl player1;
    private final RemoteGamePlayerImpl player2;

    private final int PADDLE_WIDTH = 10, PADDLE_HEIGHT = 100;
    private final int BALL_SIZE = 20;
    private int ballX = 390, ballY = 290;
    private int ballXDir = -1, ballYDir = -1;

    public BallTask(int ballSpeed, List<RemoteGamePlayerImpl> players) {
        this.ballSpeed = ballSpeed;
        this.players = players;

        player1 = players.stream().filter(player -> player.id() == 1).findFirst().get();
        player2 = players.stream().filter(player -> player.id() == 2).findFirst().get();
    }

    @Override
    public void run() {
        while (true) {
            tick();
            try {
                Thread.sleep(ballSpeed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void tick() {
        // ball logic

        ballX += ballXDir;
        ballY += ballYDir;

        if (ballY <= 0 || ballY >= getHeight() - BALL_SIZE) {
            ballYDir = -ballYDir;
        }

        if (ballX <= 40 && ballY >= player1.paddleY() && ballY <= player1.paddleY() + PADDLE_HEIGHT) {
            ballXDir = -ballXDir;
        }

        if (ballX >= getWidth() - 60 && ballY >= player2.paddleY() && ballY <= player2.paddleY() + PADDLE_HEIGHT) {
            ballXDir = -ballXDir;
        }

        if (ballX <= 0 || ballX >= getWidth()) { //TODO: dont use 0 because no score is added
            // check which player scored and add point - reversed because player 1 wins when ball is on player 2 side and player 2 wins when ball is on player 1 side
            if (ballX < 700) {
                player2.updateScore(player2.score() + 1);
            } else {
                player1.updateScore(player1.score() + 1);
            }

            ballX = 390;
            ballY = 290;
            ballXDir = -1;
            ballYDir = -1;
        }

        // send ball position to clients
        players.forEach(player -> player.getChannelTransmit().sendPacket(new S2CBallPositionUpdatePacket(ballX, ballY)));
    }

    public int getWidth() {
        return 800;
    }

    public int getHeight() {
        return 600;
    }
}
