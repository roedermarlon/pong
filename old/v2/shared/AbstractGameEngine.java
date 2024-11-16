package de.marlonr.schule.v2.shared;

public abstract class AbstractGameEngine {
    public abstract void movePaddle1Up();

    public abstract void movePaddle1Down(int height);

    public abstract void movePaddle2Up();

    public abstract void movePaddle2Down(int height);

    public abstract void updateBallPosition(int width, int height);

    public abstract int getPaddle1Y();

    public abstract int getPaddle2Y();

    public abstract int getBallX();

    public abstract int getBallY();

    public abstract int getPaddleWidth();

    public abstract int getPaddleHeight();

    public abstract int getBallSize();

    public abstract void setPaddle1Y(int paddle1Y, boolean send);

    public abstract void setPaddle2Y(int paddle2Y, boolean send);

    public abstract void setBallX(int ballX, boolean send);

    public abstract void setBallY(int ballY, boolean send);

    public abstract void setBallXDir(int ballXDir, boolean send);

    public abstract void setBallYDir(int ballYDir, boolean send);
}