package de.marlonr.schule.v2.frontend;

import de.marlonr.game.packet.C2SUpdatePacket;
import de.marlonr.schule.v2.shared.AbstractGameEngine;

public class RemoteGameEngineImpl extends AbstractGameEngine {
    protected final int PADDLE_WIDTH = 10, PADDLE_HEIGHT = 100;
    protected final int BALL_SIZE = 20;
    protected int paddle1Y = 250, paddle2Y = 250;
    protected int ballX = 390, ballY = 290;
    protected int ballXDir = -1, ballYDir = -1;

    public static AbstractGameEngine getInstance() {
        return new RemoteGameEngineImpl();
    }

    @Override
    public void movePaddle1Up() {
        if (paddle1Y > 0) {
            paddle1Y -= 20;
        }
    }

    @Override
    public void movePaddle1Down(int height) {
        if (paddle1Y < height - PADDLE_HEIGHT) {
            paddle1Y += 20;
        }
    }

    @Override
    public void movePaddle2Up() {
        if (paddle2Y > 0) {
            paddle2Y -= 20;
        }
    }

    @Override
    public void movePaddle2Down(int height) {
        if (paddle2Y < height - PADDLE_HEIGHT) {
            paddle2Y += 20;
        }
    }

    @Override
    public void updateBallPosition(int width, int height) {
        ballX += ballXDir;
        ballY += ballYDir;

        if (ballY <= 0 || ballY >= height - BALL_SIZE) {
            ballYDir = -ballYDir;
        }

        if (ballX <= 40 && ballY >= paddle1Y && ballY <= paddle1Y + PADDLE_HEIGHT) {
            ballXDir = -ballXDir;
        }

        if (ballX >= width - 60 && ballY >= paddle2Y && ballY <= paddle2Y + PADDLE_HEIGHT) {
            ballXDir = -ballXDir;
        }

        if (ballX < 0 || ballX > width) {
            ballX = 390;
            ballY = 290;
            ballXDir = -1;
            ballYDir = -1;
        }
    }

    @Override
    public int getPaddle1Y() {
        return paddle1Y;
    }

    @Override
    public int getPaddle2Y() {
        return paddle2Y;
    }

    @Override
    public int getBallX() {
        return ballX;
    }

    @Override
    public int getBallY() {
        return ballY;
    }

    @Override
    public int getPaddleWidth() {
        return PADDLE_WIDTH;
    }

    @Override
    public int getPaddleHeight() {
        return PADDLE_HEIGHT;
    }

    @Override
    public int getBallSize() {
        return BALL_SIZE;
    }

    @Override
    public void setPaddle1Y(int paddle1Y, boolean send) {
        this.paddle1Y = paddle1Y;

        if (send) {
            FrontendCommunicationClient.getInstance().getCommunicationClient().sendPacket(new C2SUpdatePacket(getLocalY()));
        }
    }

    @Override
    public void setPaddle2Y(int paddle2Y, boolean send) {
        this.paddle2Y = paddle2Y;

        if (send) {
            FrontendCommunicationClient.getInstance().getCommunicationClient().sendPacket(new C2SUpdatePacket(getLocalY()));
        }
    }

    @Override
    public void setBallX(int ballX, boolean send) {
        this.ballX = ballX;
    }

    @Override
    public void setBallY(int ballY, boolean send) {
        this.ballY = ballY;
    }

    @Override
    public void setBallXDir(int ballXDir, boolean send) {
        this.ballXDir = ballXDir;
    }

    @Override
    public void setBallYDir(int ballYDir, boolean send) {
        this.ballYDir = ballYDir;
    }

    int getLocalY() {
        // TODO
        return 1;
    }
}
